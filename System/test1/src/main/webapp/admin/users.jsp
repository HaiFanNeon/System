<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>用户列表展示</title>
        <style>
            table {
                width: 80%;
                margin: 20px auto;
                border-collapse: collapse;
            }
            th, td {
                padding: 10px;
                text-align: center;
                border: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h2 style="text-align: center">用户信息列表</h2>
        <table>
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>邮箱</th>
                <th>角色</th>
                <th>创建时间</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.createTime}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>