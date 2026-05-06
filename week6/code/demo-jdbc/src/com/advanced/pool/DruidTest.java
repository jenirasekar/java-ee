package com.advanced.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest {

    @Test
    public void testHardCodeDruid() throws SQLException {
        // Step 1: Create a Druid connection pool object
        DruidDataSource druidDataSource = new DruidDataSource();

// Step 2: Configure the connection pool
// Required settings
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///atguigu");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("abc123");

// Optional settings
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(20);

// Step 3: Obtain a connection from the connection pool
        Connection connection = druidDataSource.getConnection();
        System.out.println(connection);

// Use the connection to perform CRUD operations

// Step 4: Close the connection
// In a connection pool, close() actually returns the connection to the pool
        connection.close();
    }

    @Test
    public void testResourcesDruid() throws Exception {

        // Step 1: Create a Properties object
        // It will store the configuration information from the external file
        Properties properties = new Properties();

        // Step 2: Read the external configuration file
        // and load its content into the Properties object
        InputStream inputStream = DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(inputStream);

        // Step 3: Create the Druid connection pool
        // based on the configuration in the Properties object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // Step 4: Obtain a connection from the connection pool
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // Step 5: Perform CRUD operations

        // Step 6: Close the connection
        // In fact, the connection is returned to the pool
        connection.close();
    }
}
