<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>添加商品</title>
</head>
<body>

    <form action="<c:url value="/update"/>" method="post">
        <input type="hidden" name="id" value="${requestScope.commodity.id}">
        商品名称：<input type="text" name="name" value="${requestScope.commodity.name}">
        商品价格：<input type="text" name="price" value="${requestScope.commodity.price}">
        商品描述：<input type="text" name="describe" value="${requestScope.commodity.describe}">
        <input type="submit" value="修改商品">
    </form>
    <p style="color:#ff0000;">${requestScope.error}</p>
</body>
</html>
