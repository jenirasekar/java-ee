package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.dao.impl.SysUserDaoImpl;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.util.MD5Util;

/**
 * Implementation class of SysUserService.
 * It handles user-related business logic, such as registration and user query.
 */
public class SysUserServiceImpl implements SysUserService {

    // Create a DAO object to access the sys_user table
    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {

        // Convert the user's plaintext password into an encrypted password
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));

        // Call the DAO layer method to save the user information into the database
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {

        // Call the DAO layer method to query user information by username
        return userDao.findByUsername(username);
    }
}