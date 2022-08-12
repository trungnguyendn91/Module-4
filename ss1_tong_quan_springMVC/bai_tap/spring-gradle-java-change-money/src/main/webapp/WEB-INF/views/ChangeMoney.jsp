<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/12/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Đổi tiền</H1>
<form action="/result" method="get">
    <p>Nhập số tiền (USD)</p>
    <input type="number" name="usd" id="usd" value="${usd}"/>
    <button type="submit">Change Money</button>
</form>
<p>Số tiền VND là</p>
<p>${vnd}</p>
</body>
</html>
