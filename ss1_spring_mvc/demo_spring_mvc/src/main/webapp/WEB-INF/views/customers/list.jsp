<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 8/1/26
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <c:forEach var="c" items="${customerList}">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/customers/detail?id=${c.id}">${c.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
