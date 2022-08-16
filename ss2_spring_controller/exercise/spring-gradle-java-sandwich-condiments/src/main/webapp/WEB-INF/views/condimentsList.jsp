<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/12/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Sandwich Condiments</H1>
<form action="/save" method="get">
    <c:forEach items="${condiments}" var="condiments">
        <input type="checkbox" name="condiments" value="${condiments}"><lable>${condiments}</lable>
    </c:forEach>
    <input type="submit" name="select">
</form>
<p>Choose Sandwich Condiments: </p>
<c:if test="${message!=null}">
    <h4 style="color: red">${message}</h4>
</c:if>
<c:if test="${select!=null}">
    <c:forEach items="${select}" var="save">
        <h4 style="color: green">${select}</h4>
    </c:forEach>
</c:if>
</body>
</html>
