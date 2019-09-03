package com.example.mapper;


import com.example.entity.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper {

    SysUserRole selectByPrimaryKey(Integer id);

    List<SysUserRole> getUserRoleByUserId(String userId);

}