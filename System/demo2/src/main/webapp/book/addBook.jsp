<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/12/15
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加图书</title>
    <style>
        .form-container {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .submit-btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>添加图书信息</h2>
        <form action="addBook" method="get">
            <div class="form-group">
                <label for="title">书名:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="author">作者:</label>
                <input type="text" id="author" name="author" required>
            </div>
            <div class="form-group">
                <label for="publisher">出版社:</label>
                <input type="text" id="publisher" name="publisher" required>
            </div>
            <div class="form-group">
                <label for="isbn">ISBN:</label>
                <input type="text" id="isbn" name="isbn" required>
            </div>
            <div class="form-group">
                <label for="category">分类:</label>
                <input type="text" id="category" name="category" required>
            </div>
            <div class="form-group">
                <label for="quantity">数量:</label>
                <input type="number" id="quantity" name="quantity" required>
            </div>
            <button type="submit" class="submit-btn">提交</button>
        </form>
    </div>
</body>
</html>
