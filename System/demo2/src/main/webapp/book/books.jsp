<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/12/15
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理</title>
    <style>
        .container {
            width: 80%;
            margin: 20px auto;
        }
        .add-button {
            float: left;
            margin-bottom: 20px;
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            margin-right: 10px;
        }
        .add-button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            clear: both;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <%
        if(request.getAttribute("bookList") == null) {
            request.getRequestDispatcher("/book/bookList").forward(request, response);
            return;
        }
    %>

    <div class="container">
        <a href="addBook.jsp" class="add-button">新增图书</a>
        <a href="../admin/users.jsp" class="add-button">用户管理</a>
        <h2 style="text-align: center">图书信息列表</h2>
        
        <c:if test="${not empty bookList}">
            <table>
                <tr>
                    <th>图书ID</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>ISBN</th>
                    <th>分类</th>
                    <th>数量</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>

                <c:forEach var="book" items="${bookList}" varStatus="status">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td>${book.isbn}</td>
                        <td>${book.category}</td>
                        <td>${book.quantity}</td>
                        <td>${book.createTime}</td>
                        <td>
                            <a href="editBook?id=${book.id}">编辑</a>
                            <a href="deleteBook?id=${book.id}" onclick="return confirm('确定要删除吗？')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>