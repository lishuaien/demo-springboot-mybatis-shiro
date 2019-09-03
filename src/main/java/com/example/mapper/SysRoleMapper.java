package com.example.mapper;


import com.example.entity.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {

    SysRole selectByPrimaryKey(Integer id);

    SysRole getSysRoleByRoleId(String roleId);
}