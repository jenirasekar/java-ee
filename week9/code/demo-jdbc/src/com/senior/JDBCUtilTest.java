package com.senior;

import com.senior.util.JDBCUtil;
import com.senior.util.JDBCUtilV2;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {
    @Test
    public void testGetConnection(){
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);

        JDBCUtil.release(connection);
    }

    @Test
    public void testJDBCV2(){
        Connection connection1 = JDBCUtil.getConnection();
        Connection connection2 = JDBCUtil.getConnection();
        Connection connection3 = JDBCUtil.getConnection();
        System.out.println(connection1);
        System.out.println(connection2);
        System.out.println(connection3);

        Connection connectionv21 = JDBCUtilV2.getConnection();
        Connection connectionv22 = JDBCUtilV2.getConnection();
        Connection connectionv23 = JDBCUtilV2.getConnection();
        System.out.println(connectionv21);
        System.out.println(connectionv22);
        System.out.println(connectionv23);

//        JDBCUtil.release(connection);
    }
}
