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
<H1>Từ Điển</H1>
<form action="/result" method="get">
    <p>Nhập từ cần tìm (eng)</p>
    <input type="text" name="eng" id="eng" value="${eng}"/>
    <button type="submit">Translate</button>
</form>
<p>Tiếng Việt :</p>
<c:if test="${result!=null}">
    <h4>${result}</h4>
</c:if>
<c:if test="${error!=null}">
    <h4>${error}</h4>
</c:if>
</body>
</html>
