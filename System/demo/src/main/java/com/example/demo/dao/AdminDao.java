package com.example.demo.dao;

import com.example.demo.pojo.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    public int login(String username, String password);


    public List<Users> getAllUsers();
}