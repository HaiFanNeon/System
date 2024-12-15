<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/12/15
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除用户</title>
    <style>
        .container {
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
        .btn {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>删除用户</h2>
        <form action="deleteUser" method="get" onsubmit="return confirm('确定要删除该用户吗？');">
            <div class="form-group">
                <label for="userId">用户ID:</label>
                <input type="text" id="userId" name="userId" required>
            </div>
            
            <button type="submit" class="btn">删除用户</button>
        </form>
        
        <%-- 显示操作结果消息 --%>
        <% 
            String message = (String)request.getAttribute("message");
            if(message != null && !message.isEmpty()) {
        %>
            <div style="margin-top: 20px; color: <%= message.startsWith("成功") ? "green" : "red" %>;">
                <%= message %>
            </div>
        <% } %>
    </div>
</body>
</html>
