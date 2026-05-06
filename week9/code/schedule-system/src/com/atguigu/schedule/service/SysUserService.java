package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysUser;

/**
 * This interface defines business operations related to the sys_user table.
 */
public interface SysUserService {

    /**
     * Register a new user.
     * @param sysUser The user object containing the username and plaintext password.
     * @return Return 1 if registration succeeds; return 0 if registration fails.
     */
    int regist(SysUser sysUser);

    /**
     * Get complete user information according to the username.
     * @param username The username to query.
     * @return Return a SysUser object if found; otherwise, return null.
     */
    SysUser findByUsername(String username);
}