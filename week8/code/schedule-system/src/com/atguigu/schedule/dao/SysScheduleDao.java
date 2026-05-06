package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * DAO interface for the sys_schedule table.
 * It defines database operations related to schedule records.
 */
public interface SysScheduleDao {

    /**
     * Add a schedule record to the database.
     * @param schedule The schedule data received as a SysSchedule entity object.
     * @return Return the number of affected rows. 0 means failure, greater than 0 means success.
     */
    int addSchedule(SysSchedule schedule);

    /**
     * Query all schedules of all users.
     * @return Return all schedule records as a List<SysSchedule>.
     */
    List<SysSchedule> findAll();

}