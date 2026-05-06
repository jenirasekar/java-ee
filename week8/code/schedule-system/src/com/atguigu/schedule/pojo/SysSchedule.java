package com.atguigu.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Entity class corresponding to the sys_schedule table.
 */
@AllArgsConstructor // Generate an all-argument constructor
@NoArgsConstructor  // Generate a no-argument constructor
@Data                // Generate getter, setter, equals, hashCode, and toString
public class SysSchedule implements Serializable {
    private Integer sid;       // Schedule ID
    private Integer uid;       // User ID
    private String title;      // Schedule title
    private Integer completed; // Completion status: 0 means unfinished, 1 means completed
}