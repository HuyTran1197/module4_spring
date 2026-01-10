<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 10/1/26
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tra từ điển Việt - Anh</h1>
<form action="form" method="get">
    <label>Tiếng Việt</label>
    <input type="text" name="find" placeholder="Nhập từ tiếng Việt"/>
    <button>Dịch</button>
</form>
<h2>Tiếng Anh: ${eng}</h2>
<c:if test="${empty eng}">
    <h2>${eng}</h2>
</c:if>
</body>
</html>
