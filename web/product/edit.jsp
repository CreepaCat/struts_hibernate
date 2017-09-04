<%--
  Created by IntelliJ IDEA.
  User: ghost
  Date: 2017/9/2
  Time: 9:49
 编辑单条
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="utf-8" import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>编辑产品</title>
</head>
<body>
<h1 align="center">edit</h1>
<form name="updateProduct" action="updateProduct" method="post">
<table align="center" cellspacing="0" width="500px">
    <tr>
        <td>id:</td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>name:</td>
        <td><input type="text" name="product.name" value="${product.name}"/> </td>
    </tr>
    <tr>
        <td>price:</td>
        <td><input type="text" name="product.price" value="${product.price}"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="hidden" name="product.id" value="${product.id}">
            <input type="submit" value="submit"/></td>
    </tr>
</table>
</form>
</body>
</html>
