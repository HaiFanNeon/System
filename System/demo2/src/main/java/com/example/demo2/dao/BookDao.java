package com.example.demo2.dao;

import com.example.demo2.entity.Books;

import java.util.List;

public interface BookDao {
    //查询所有图书
    public List<Books> bookList();


    int addBook(Books books);
}
