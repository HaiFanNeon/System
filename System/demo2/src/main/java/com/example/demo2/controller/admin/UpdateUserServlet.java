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

@WebServlet("/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        Users user = adminService.getUserById(id);
        user.setUsername(username);
        if (password != null && !password.trim().isEmpty()) {
            user.setPassword(password);
        }
        user.setEmail(email);
        user.setRole(role);

        adminService.updateUser(user);

        List<Users> userList = adminService.getAllUsers();
        System.out.println(userList.size());
        System.out.println(userList.get(1).getUsername());
        request.setAttribute("userList", userList);
        log("登录成功");
        request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
    }
}