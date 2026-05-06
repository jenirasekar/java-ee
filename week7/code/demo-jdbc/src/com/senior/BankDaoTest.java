package com.senior;

import com.senior.dao.BankDao;
import com.senior.dao.impl.BankDaoImpl;
import com.senior.util.JDBCUtilV2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class BankDaoTest {

    @Test
    public void testTransaction(){
        BankDao dao = new BankDaoImpl();
        Connection conn = null;

        try {
            conn = JDBCUtilV2.getConnection();
            conn.setAutoCommit(false);

            dao.subMoney(1,100);
            int i = 10/0;
            dao.addMoney(2,100);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            JDBCUtilV2.release();
        }


    }
}
