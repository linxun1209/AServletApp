<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>商品列表页</title>
</head>
<body>
    <a href="/add">添加商品</a>
    <table>
        <tr>
            <th>名称</th>
            <th>价格</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.data}" var="c" varStatus="s">
        <tr>
            <td>${c.name}</td>
            <td>${c.price}</td>
            <td>${c.describe}</td>
            <td><a href="/delete?id=${c.id}">删除</a>|<a href="/update?id=${c.id}">修改</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
