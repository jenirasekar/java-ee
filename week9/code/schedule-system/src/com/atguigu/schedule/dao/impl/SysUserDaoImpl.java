package com.atguigu.schedule.dao.impl;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.pojo.SysUser;

import java.util.List;

/**
 * Implementation class of SysUserDao.
 * It is responsible for database operations related to the sys_user table.
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public int addSysUser(SysUser sysUser) {

        // SQL statement for inserting a new user record
        String sql = "insert into sys_user values(DEFAULT,?,?)";

        // Execute the insert operation
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {

        // Query user information by username
        // Use alias userPwd to match the field name in SysUser
        String sql = "select uid, username, user_pwd userPwd from sys_user where username = ?";

        // Execute the query and return a list of users
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);

        // If the user exists, return the first user object; otherwise, return null
        return sysUserList != null && sysUserList.size() > 0 ? sysUserList.get(0) : null;
    }
}