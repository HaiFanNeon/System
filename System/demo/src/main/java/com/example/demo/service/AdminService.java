package com.example.demo.service;

import com.example.demo.pojo.entity.Users;

import java.util.List;

public interface AdminService {

    public int login(String username, String password);

    public List<Users> getAllUsers();
}
