package com.example.test1.service;

import com.example.test1.pojo.entity.Users;

import java.util.List;

public interface AdminService {

    public int login(String username, String password);

    public List<Users> getAllUsers();
}
