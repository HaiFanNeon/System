package com.example.test1.pojo.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Books {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String category;
    private Integer quantity;
    private Date createTime;
}