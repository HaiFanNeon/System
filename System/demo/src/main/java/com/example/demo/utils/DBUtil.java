package com.example.demo.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Properties properties = null;
    static {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("appliocation.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(properties.getProperty("driver"));
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, PreparedStatement psmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (psmt != null) {
            try {
                psmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

