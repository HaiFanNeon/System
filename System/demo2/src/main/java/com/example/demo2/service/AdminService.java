package com.example.demo2.service;

import com.example.demo2.entity.Users;

import java.util.List;

public interface AdminService {

    public int login(String username, String password);

    public List<Users> getAllUsers();

    void addUser(Users user);

    Users getUserById(String id);

    void updateUser(Users user);

    int deleteUser(String id);
}
