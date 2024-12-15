<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/12/15
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>新增用户</title>
    <style>
        .container {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-primary {
            background-color: #4CAF50;
            color: white;
        }
        .btn-primary:hover {
            background-color: #45a049;
        }
        .btn-default {
            background-color: #f2f2f2;
            margin-right: 10px;
        }
        .btn-default:hover {
            background-color: #e6e6e6;
        }
        .error {
            color: red;
            font-size: 12px;
            margin-top: 5px;
            display: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>新增用户</h2>
    <form action="addUser" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username" required
                   pattern=".{3,20}" title="用户名长度需在3-20个字符之间">
            <div class="error" id="username-error">用户名不能为空且长度在3-20个字符之间</div>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" required
                   pattern=".{6,20}" title="密码长度需在6-20个字符之间">
            <div class="error" id="password-error">密码不能为空且长度在6-20个字符之间</div>
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="email" id="email" name="email" required>
            <div class="error" id="email-error">请输入有效的邮箱地址</div>
        </div>

        <div class="form-group">
            <label for="role">角色：</label>
            <select id="role" name="role" required>
                <option value="">请选择角色</option>
                <option value="admin">管理员</option>
                <option value="user">普通用户</option>
            </select>
            <div class="error" id="role-error">请选择用户角色</div>
        </div>

        <div class="form-group">
            <button type="button" class="btn btn-default" onclick="window.location.href='users.jsp'">返回</button>
            <button type="submit" class="btn btn-primary">保存</button>
        </div>
    </form>
</div>

<script>
    function validateForm() {
        let isValid = true;

        // 验证用户名
        const username = document.getElementById('username');
        if (!username.value || username.value.length < 3 || username.value.length > 20) {
            document.getElementById('username-error').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('username-error').style.display = 'none';
        }

        // 验证密码
        const password = document.getElementById('password');
        if (!password.value || password.value.length < 6 || password.value.length > 20) {
            document.getElementById('password-error').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('password-error').style.display = 'none';
        }

        // 验证邮箱
        const email = document.getElementById('email');
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!email.value || !emailPattern.test(email.value)) {
            document.getElementById('email-error').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('email-error').style.display = 'none';
        }

        // 验证角色
        const role = document.getElementById('role');
        if (!role.value) {
            document.getElementById('role-error').style.display = 'block';
            isValid = false;
        } else {
            document.getElementById('role-error').style.display = 'none';
        }

        return isValid;
    }
</script>
</body>
</html>