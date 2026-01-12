<%--
  Created by IntelliJ IDEA.
  User: tranvanphathuy
  Date: 11/1/26
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gia vị sandwich</h1>
<form action="sandwich" method="get">
        <input type="checkbox" id="myCheckbox" name="condiment" value="Lettuce"/>
        <label for="myCheckbox">Lettuce</label>
        <input type="checkbox" id="myCheckbox" name="condiment" value="Tomato"/>
        <label for="myCheckbox">Tomato</label>
        <input type="checkbox" id="myCheckbox" name="condiment" value="Mustard"/>
        <label for="myCheckbox">Mustard</label>
        <input type="checkbox" id="myCheckbox" name="condiment" value="Sprouts"/>
        <label for="myCheckbox">Sprouts</label><br>
    <button>Save</button>
</form>
</body>
</html>
