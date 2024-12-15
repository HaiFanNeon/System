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

@WebServlet("/admin/editUser")
public class FindUserServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Users user = adminService.getUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/admin/editUser.jsp").forward(request, response);
    }
}
