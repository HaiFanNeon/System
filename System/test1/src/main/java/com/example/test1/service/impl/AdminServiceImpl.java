package com.example.test1.service.impl;

import com.example.test1.dao.AdminDao;
import com.example.test1.dao.imp.AdminDaoImpl;
import com.example.test1.pojo.entity.Users;
import com.example.test1.service.AdminService;

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
