package com.example.demo2.controller.admin;


import com.example.demo2.entity.Users;
import com.example.demo2.service.AdminService;
import com.example.demo2.service.impl.AdminServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/LoginServlet")
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
            System.out.println(userList.size());
            System.out.println(userList.get(1).getUsername());
            req.setAttribute("userList", userList);
            log("登录成功");
            req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
        }
        req.setAttribute("error", "用户名或密码错误");
        req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
    }
}
