<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 12/1/26
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Máy tính cá nhân</title>
</head>
<body>
<h1>Máy tính cá nhân</h1>
<form action="calculator" method="get">
  <input name="num1" placeholder="enter the first number">
  <input name="num2" placeholder="enter the second number"><br>

  <button name="action" value="sum">Addition(+)</button>
  <button name="action" value="sub">Subtraction(-)</button>
  <button name="action" value="multip">Multiplication(*)</button>
  <button name="action" value="division">Division(/)</button>
</form>
<h3>Result = ${result}</h3>
<c:if test="${not empty mess}">
  <h3>${mess}</h3>
</c:if>
</body>
</html>
