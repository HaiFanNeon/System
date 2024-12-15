package com.example.demo.controller.admin;


import com.example.demo.pojo.entity.Users;
import com.example.demo.service.AdminService;
import com.example.demo.service.impl.AdminServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("------------------");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 登录逻辑
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        int login = adminService.login(username, password);
        if (login == 1) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            List<Users> userList = adminService.getAllUsers();
            req.setAttribute("userList", userList);
            log("登录成功");
            req.getRequestDispatcher(req.getContextPath() + "/admin/users.jsp").forward(req, resp);
        } else if (login == 0) {
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
        }
    }
}
