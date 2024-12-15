package com.example.demo2.dao.imp;

import com.example.demo2.dao.BookDao;
import com.example.demo2.entity.Books;
import com.example.demo2.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    private String sql = "";
    @Override
    public List<Books> bookList() {
        sql = "select * from books";
        List<Books> listBook = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            psmt = con.prepareCall(sql);
            rs = psmt.executeQuery();
            while (rs.next()){
                //获取数据
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getString("isbn"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
                book.setCreateTime(rs.getDate("create_time"));
                listBook.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs,psmt,con);
        }
        return listBook;
    }

    @Override
    public int addBook(Books books) {
        sql = "insert into books(title,author,publisher,isbn,category,quantity) values(?,?,?,?,?,?)";
        con = DBUtil.getConnection();
        int ret = 0;
        try {
            psmt = con.prepareCall(sql);

            psmt.setString(1,books.getTitle());
            psmt.setString(2,books.getAuthor());
            psmt.setString(3,books.getPublisher());
            psmt.setString(4,books.getIsbn());
            psmt.setString(5,books.getCategory());
            psmt.setInt(6,books.getQuantity());

            ret = psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs,psmt,con);
        }
        return ret;
    }
}
