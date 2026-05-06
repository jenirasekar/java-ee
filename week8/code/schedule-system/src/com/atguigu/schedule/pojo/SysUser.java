package com.atguigu.schedule.pojo;

import lombok.*;

import java.io.Serializable;

/*
 * Notes about entity classes:
 *
 * 1. The class name should correspond to the table name.
 * 2. The field names should correspond to the column names in the table.
 * 3. Each field should be private.
 * 4. Each field should have getter and setter methods.
 * 5. A no-argument constructor is required.
 * 6. It is recommended to implement Serializable.
 *    In cache or distributed systems, objects may need to be serialized.
 * 7. It is recommended to override hashCode() and equals().
 * 8. Overriding toString() is optional.
 *
 * Lombok can help us generate these methods automatically:
 * getter, setter, all-argument constructor, no-argument constructor,
 * equals(), hashCode(), and toString().
 *
 * Steps to use Lombok:
 * 1. Check whether the Lombok plugin is installed in IDEA.
 * 2. Check whether "Enable annotation processing" is selected.
 * 3. Import the Lombok dependency.
 */

@AllArgsConstructor // Generate an all-argument constructor
@NoArgsConstructor  // Generate a no-argument constructor
@Data                // Generate getter, setter, equals, hashCode, and toString
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
}