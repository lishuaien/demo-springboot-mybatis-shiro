package com.example.shiro;

import com.example.entity.*;
import com.example.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EnceladusShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principals.getPrimaryPrincipal();

        SysUser user = userService.findUserByName(username);

        List<SysUserRole> sysUserRoleList = userService.getUserRoleByUserId(user.getUserId());

        List<SysRole> sysRoleList = new ArrayList<>();
        for(SysUserRole sysUserRole : sysUserRoleList) {
            SysRole sysRole = userService.getSysRoleByRoleId(sysUserRole.getRoleId());
            sysRoleList.add(sysRole);
        }

        for (SysRole role : sysRoleList) {
            authorizationInfo.addRole(role.getRoleName());
            List<SysRolePermission> sysRolePermissionList = userService.getSysRolePermissionByRoleId(role.getRoleId());

            List<SysPermission> sysPermissionList = new ArrayList<>();

            for(SysRolePermission sysRolePermission : sysRolePermissionList) {
                SysPermission sysPermission = userService.getSysPermissionById(sysRolePermission.getPermissionId());
                sysPermissionList.add(sysPermission);
            }

            for (SysPermission permission : sysPermissionList) {
                authorizationInfo.addStringPermission(permission.getPermissionName());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser user = userService.findUserByName(username);

        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
        return authenticationInfo;
    }

}
