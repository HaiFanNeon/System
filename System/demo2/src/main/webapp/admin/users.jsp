<%@ page import="com.example.demo2.entity.Users" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <title>用户列表展示</title>
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
                margin-right: 10px; /* 添加右边距 */
            }

            .add-button:last-child {
                margin-right: 0; /* 最后一个按钮不需要右边距 */
            }

        </style>
    </head>
    <body>

    <%
        // 如果userList为空，则转发到获取用户列表的Servlet
        if(request.getAttribute("userList") == null) {
            request.getRequestDispatcher("/admin/userList").forward(request, response);
            return;
        }
    %>

        <div class="container">
            <a href="addUser.jsp" class="add-button">新增用户</a>
            <a href="${pageContext.request.contextPath}/book/books.jsp" class="add-button" style="margin-left: 10px;">图书管理</a>
            <h2 style="text-align: center">用户信息列表</h2>
            <c:if test="${not empty userList}">
            <table>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>邮箱</th>
                    <th>角色</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>

                <c:forEach var="user" items="${userList}" varStatus="status">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td>${user.createTime}</td>
                        <td>
                            <a href="editUser?id=${user.id}">编辑</a>
                            <a href="deleteUser?id=${user.id}" onclick="return confirm('确定要删除吗？')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>