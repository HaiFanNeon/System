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
import java.util.Date;
import java.util.List;

@WebServlet("/admin/saveUser")
public class AddUserServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        user.setCreateTime(new Date());

        adminService.addUser(user);

        List<Users> userList = adminService.getAllUsers();
        System.out.println(userList.size());
        System.out.println(userList.get(1).getUsername());
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
    }
}
