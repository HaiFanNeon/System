package com.example.demo2.controller.book;


import com.example.demo2.entity.Books;
import com.example.demo2.service.BookService;
import com.example.demo2.service.impl.BookServiceImpl;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet("/book/addBook")
public class AddBookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Book对象
        Books book = new Books();

        // 使用BeanUtils将请求参数映射到Book对象
        try {
            BeanUtils.populate(book, req.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(book.toString());
        // 设置创建时间
        book.setCreateTime(new Date());
        // 调用BookService的addBook方法添加书籍
        bookService.addBook(book);
        // 重定向到书籍列表页面
        resp.sendRedirect(req.getContextPath() +"/book/books.jsp");

    }
}
