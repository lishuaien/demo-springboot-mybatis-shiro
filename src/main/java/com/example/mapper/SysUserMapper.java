package com.example.mapper;


import com.example.entity.SysUser;
import com.example.entity.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    SysUser findUserByName(String userName);

    void saveUser(SysUser user);

}