<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/15/2022
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    table {
        border: 1px solid #000;
    }
    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${requestScope.customers.size()} customer(s) in list.

<form action="/view" method="get">
    <table>
        <caption>Customers List</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <c:forEach var="c" items="${customers}">
            <tr>
                <td>
                    <c:out value="${c.id}"/>
                </td>
                <td>
                    <a href="info.jsp?id=${c.id}">${c.name}</a>
                </td>
                <td>
                    <c:out value="${c.email}"/>
                </td>
                <td>
                    <c:out value="${c.address}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
