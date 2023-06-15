<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>添加商品</title>
</head>
<body>

    <form action="<c:url value="/add"/>" method="post">
        商品名称：<input type="text" name="name">
        商品价格：<input type="text" name="price">
        商品描述：<input type="text" name="describe">
        <input type="submit" value="添加商品">
    </form>
    <p style="color:red;">${requestScope.error}</p>
</body>
</html>
