package com.example.demo2.controller.admin;

import com.example.demo2.entity.Users;
import com.example.demo2.service.AdminService;
import com.example.demo2.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/userList")
public class UserListServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 获取用户列表数据

            List<Users> userList = adminService.getAllUsers();

            // 将数据存储到request中
            request.setAttribute("userList", userList);

            // 转发到用户列表页面
            request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
