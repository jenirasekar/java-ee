package com.atguigu.schedule.dao.impl;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * Implementation class of SysScheduleDao.
 * It is responsible for database operations related to the sys_schedule table.
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) {

        // SQL statement for inserting a new schedule record
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";

        // Execute the insert operation
        int rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());

        // Return the number of affected rows
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {

        // SQL statement for querying all schedule records
        String sql = "select sid, uid, title, completed from sys_schedule";

        // Execute the query and return the schedule list
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql);

        return scheduleList;
    }
}