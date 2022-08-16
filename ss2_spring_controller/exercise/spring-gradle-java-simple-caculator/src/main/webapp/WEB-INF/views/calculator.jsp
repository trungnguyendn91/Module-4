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
<h1>Máy Tính</h1>
<form method="get" action="/result">
        <legend>Calculator</legend>
        <input name="number1" type="text" value="${number1}"/>
        <input name="number2" type="text" value="${number2}"/>
        <select type="submit" name="operator">
            <option value="+">Cộng</option>
            <option value="-">Trừ</option>
            <option value="*">Nhân</option>
            <option value="/">Chia</option>
        </select>
        <button type="submit">result</button>
</form>
<h4>Result</h4>
${result}
</body>
</html>
