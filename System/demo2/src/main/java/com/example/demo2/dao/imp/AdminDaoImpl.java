package com.example.demo2.dao.imp;

import com.example.demo2.dao.AdminDao;
import com.example.demo2.entity.Users;
import com.example.demo2.utils.DBUtil;

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
        int ret = 0;

        try {
            psmt = con.prepareCall(sql);

            psmt.setString(1, username);
            rs = psmt.executeQuery();
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
        List<Users> list = new ArrayList<>();
        try {
            psmt = con.prepareCall(sql);
            rs = psmt.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setCreateTime(rs.getDate("create_time"));
                System.out.println(user.toString());
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }

        return list;
    }

    @Override
    public void addUser(Users user) {
        String sql = "insert into LibraryManagement.users (username, password, email, role)" +
                "values (?,?,?,?)";
        con = DBUtil.getConnection();
        try {

            psmt = con.prepareCall(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, user.getRole());
            int i = psmt.executeUpdate();
            if (i > 0) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }
    }

    @Override
    public Users getUserById(String id) {
        String sql = "select * from users where id = ?";
        Users user = new Users();
        con = DBUtil.getConnection();
        try {
            psmt = con.prepareCall(sql);
            psmt.setString(1, id);
            rs = psmt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setCreateTime(rs.getDate("create_time"));
                System.out.println(user.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }
        return user;
    }

    @Override
    public void updateUser(Users user) {
        String sql = "update users set username = ?, password = ?, email = ?, role = ? where id = ?";
        con = DBUtil.getConnection();
        try {
            psmt = con.prepareCall(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, user.getRole());
            psmt.setInt(5, user.getId());
            int i = psmt.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }
    }

    @Override
    public int deleteUser(String id) {
        String sql = "delete from users where id = ?";
        con = DBUtil.getConnection();
        int ret = 0;
        try {
            psmt = con.prepareCall(sql);
            psmt.setString(1, id);
            ret = psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, psmt, con);
        }
        return ret;
    }
}
