<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 8/1/26
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thực hiện chuyển đổi</h1>
<form action="calculate" method="get">
    <label>Tỉ giá: </label>
    <input name="rate" value="0"/>
    <label>USD: </label>
    <input name="usd" value="0"/>
    <button>=</button>
</form>
<h1>Quy đổi sang VND: ${vnd}</h1>
</body>
</html>
