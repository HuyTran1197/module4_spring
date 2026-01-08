<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 8/1/26
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông tin khách hàng</h1>
<p>
    <strong>Id: </strong>
    <input type="text" value="<c:out value="${customer.id}"/>" readonly/>
</p>
<p>
    <strong>name: </strong>
    <input type="text" value="<c:out value="${customer.name}"/>"/>
</p>
<button>Xác nhận</button>
<a href="/customers">Back to list</a>
</body>
</html>
