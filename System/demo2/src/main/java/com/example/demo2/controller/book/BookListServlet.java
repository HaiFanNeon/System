package com.example.demo2.controller.book;


import com.example.demo2.entity.Books;
import com.example.demo2.service.BookService;
import com.example.demo2.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/bookList")
public class BookListServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Books> books = bookService.bookList();
        req.setAttribute("bookList", books);
        req.getRequestDispatcher("/book/books.jsp").forward(req, resp);
    }
}
