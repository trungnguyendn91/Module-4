<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>

<form:form method="POST" action="addSetting" modelAttribute="setting">
    <fieldset>
        <table>
            <legend>Setting Box Email</legend>
            <tr>
                <td>Language</td>
                <td><form:select path="language" items="${language}"/></td>
            </tr>
            <tr>
                <td>Page Size</td>
                <td>Show <form:select path="pageSize" items="${pageSize}"/> email per page</td>
            </tr>
            <tr>
                <td>Spams Filter</td>
                <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
            </tr>
            <tr>
                <td>Signature</td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"/></td>
                <td><input type="reset" value="Cancel"/></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>