package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

public interface SysUserDao {

    /**
     * Add a user record to the database.
     * @param sysUser The SysUser object containing the username and user_pwd to be added.
     * @return Return 1 if the record is added successfully; return 0 if it fails.
     */
    int addSysUser(SysUser sysUser);

    /**
     * Get complete user information according to the username.
     * @param username The username to query.
     * @return Return a SysUser object if found; otherwise, return null.
     */
    SysUser findByUsername(String username);
}