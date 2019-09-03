package com.example.service.impl;

import com.example.entity.*;
import com.example.mapper.*;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    public SysUser getUserById(int id) {
        //SysUser user = userMapper.getUserById(id);
        return new SysUser();
    }

    public SysUser findUserByName(String username){
        return userMapper.findUserByName(username);
    }

    public List<SysUserRole> getUserRoleByUserId(String userId) {
        return userRoleMapper.getUserRoleByUserId(userId);
    }

    public SysRole getSysRoleByRoleId(String roleId) {
        return sysRoleMapper.getSysRoleByRoleId(roleId);
    }

    public List<SysRolePermission> getSysRolePermissionByRoleId(String roleId) {
        return sysRolePermissionMapper.getSysRolePermissionByRoleId(roleId);
    }

    public SysPermission getSysPermissionById(String permissionId) {
        return sysPermissionMapper.getSysPermissionById(permissionId);
    }

    public void saveUser(SysUser user){
        userMapper.saveUser(user);
    }

}
