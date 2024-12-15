package com.example.demo2.service;

import com.example.demo2.entity.Books;

import java.util.List;

public interface BookService {

    List<Books> bookList();


    int addBook(Books books);
}
