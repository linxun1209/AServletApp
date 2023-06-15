<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>登录</title>
</head>
    <body>
        <h3>请登录</h3>
        <form action="<c:url value="/login"/>" method="post">
            账号：<input type="text" name="username">
            密码：<input type="password" name="password">
            <input type="submit" value="登录">
        </form>
        <p style="color: red;">${requestScope.error}</p>
    </body>
</html>
