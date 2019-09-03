package com.example.mapper;


import com.example.entity.SysPermission;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionMapper {

    SysPermission selectByPrimaryKey(Integer id);

    SysPermission getSysPermissionById(String permissionId);

}