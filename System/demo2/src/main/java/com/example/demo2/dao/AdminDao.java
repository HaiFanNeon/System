package com.example.demo2.dao;

import com.example.demo2.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    public int login(String username, String password);


    public List<Users> getAllUsers();

    void addUser(Users user);

    Users getUserById(String id);

    void updateUser(Users user);

    int deleteUser(String id);
}