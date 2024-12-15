package com.example.demo.service.impl;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.imp.AdminDaoImpl;
import com.example.demo.pojo.entity.Users;
import com.example.demo.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public int login(String username, String password) {
        return adminDao.login(username, password);
    }

    @Override
    public List<Users> getAllUsers() {
        return adminDao.getAllUsers();
    }
}
