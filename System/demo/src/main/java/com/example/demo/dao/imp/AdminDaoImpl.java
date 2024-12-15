package com.example.demo.dao.imp;

import com.example.demo.dao.AdminDao;
import com.example.demo.pojo.entity.Users;
import com.example.demo.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    private String sql = "";

    @Override
    public int login(String username, String password) {
        String sql = "select * from users where username = ?";
        con = DBUtil.getConnection();
        psmt = null;
        rs = null;
        int ret = 0;

        try {
            psmt = con.prepareCall(sql);
            psmt.setString(1, username);
            psmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    // success
                    ret = 1;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }
        // 用户名不存在或密码错误 ret = 0
        return ret;

    }

    @Override
    public List<Users> getAllUsers() {
        String sql = "select * from users";
        con = DBUtil.getConnection();
        psmt = null;
        rs = null;
        List<Users> list = new ArrayList<>();
        try {
            rs = psmt.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setCreateTime(rs.getDate("create_time"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }

        return list;
    }
}
