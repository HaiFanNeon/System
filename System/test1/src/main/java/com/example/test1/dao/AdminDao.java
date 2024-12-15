package com.example.test1.dao;

import com.example.test1.pojo.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    public int login(String username, String password);


    public List<Users> getAllUsers();
}