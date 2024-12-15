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

@WebServlet("/admin/deleteUser")
public class deleteUser extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int ret = adminService.deleteUser(id);
        if (ret > 0) {
            List<Users> userList = adminService.getAllUsers();
            System.out.println(userList.size());
            System.out.println(userList.get(1).getUsername());
            req.setAttribute("userList", userList);
            req.setAttribute("messsage", "删除成功");
            req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
        } else {
            req.setAttribute("messsage", "删除失败");
            resp.sendRedirect("/admin/users.jsp");
        }
    }
}
