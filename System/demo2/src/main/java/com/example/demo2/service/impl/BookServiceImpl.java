package com.example.demo2.service.impl;

import com.example.demo2.dao.BookDao;
import com.example.demo2.dao.imp.BookDaoImpl;
import com.example.demo2.entity.Books;
import com.example.demo2.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Books> bookList() {
        List<Books> books = bookDao.bookList();
        if (books == null) {
            return null;
        }
        return books;
    }

    @Override
    public int addBook(Books books) {
        return bookDao.addBook(books);
    }
}
