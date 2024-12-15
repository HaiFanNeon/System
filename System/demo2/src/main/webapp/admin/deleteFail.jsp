<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/12/15
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除失败</title>
    <style>
        .container {
            width: 400px;
            margin: 100px auto;
            text-align: center;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        
        .error-message {
            color: #dc3545;
            font-size: 18px;
            margin: 20px 0;
        }
        
        .back-btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
        
        .back-btn:hover {
            background-color: #0056b3;
        }
        
        .error-icon {
            font-size: 48px;
            color: #dc3545;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-icon">✖</div>
        <div class="error-message">
            删除用户失败！
            <% 
                String errorMsg = (String)request.getAttribute("errorMessage");
                if(errorMsg != null && !errorMsg.isEmpty()) {
                    out.println("<br>" + errorMsg);
                }
            %>
        </div>
        
        <a href="user.jsp" class="back-btn">返回用户管理页面</a>
    </div>
</body>
</html>
