package com.example.demo2.service.impl;

import com.example.demo2.dao.AdminDao;
import com.example.demo2.dao.imp.AdminDaoImpl;
import com.example.demo2.entity.Users;
import com.example.demo2.service.AdminService;

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

    @Override
    public void addUser(Users user) {
        adminDao.addUser(user);
    }

    @Override
    public Users getUserById(String id) {
        return adminDao.getUserById(id);
    }

    @Override
    public void updateUser(Users user) {
        adminDao.updateUser(user);
    }

    @Override
    public int deleteUser(String id) {
        return adminDao.deleteUser(id);
    }
}
