package com.example.demo2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private Date createTime;
}
