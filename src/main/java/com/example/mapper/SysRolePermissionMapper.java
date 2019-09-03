package com.example.mapper;


import com.example.entity.SysRolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRolePermissionMapper {

    SysRolePermission selectByPrimaryKey(Integer id);

    List<SysRolePermission> getSysRolePermissionByRoleId(String roleId);

}