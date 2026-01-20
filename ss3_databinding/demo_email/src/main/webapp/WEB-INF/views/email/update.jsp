<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 20/1/26
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đây là hòm mail điện tử</title>
</head>
<body>
<form:form method="post" action="/email/update" modelAttribute="email">
    Languages <form:select path="languages">
    <form:option value="English">English</form:option>
    <form:option value="Vietnamese">Vietnamese</form:option>
    <form:option value="Japanese">Japanese</form:option>
    <form:option value="Chinese">Chinese</form:option>
</form:select><br>
    Page Size: Show <form:select path="pageSize">
    <form:option value="5">5</form:option>
    <form:option value="10">10</form:option>
    <form:option value="15">15</form:option>
    <form:option value="20">20</form:option>
    <form:option value="25">25</form:option>
    <form:option value="50">50</form:option>
    <form:option value="100">100</form:option>
</form:select> emails per page<br>
    Spams fillter: <form:checkbox path="spamsFillter" value="true"/> Enable spams fillter<br>
    Signature: <form:textarea path="signature"/><br>
    <button>Update</button>
    <button type="button">Cancel</button>
</form:form>
</body>
</html>
