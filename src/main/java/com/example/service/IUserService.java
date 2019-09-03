package com.example.service;

import com.example.entity.*;

import java.util.List;

public interface IUserService {
    public SysUser getUserById(int id);

    public SysUser findUserByName(String username);

    public List<SysUserRole> getUserRoleByUserId(String userId);

    public SysRole getSysRoleByRoleId(String roleId);

    public List<SysRolePermission> getSysRolePermissionByRoleId(String roleId);

    public SysPermission getSysPermissionById(String permissionId);

    public void saveUser(SysUser user);
}
