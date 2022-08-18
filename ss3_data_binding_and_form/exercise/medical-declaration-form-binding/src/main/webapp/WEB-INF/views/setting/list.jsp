<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/17/2022
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H3 style="text-align: center">Danh sách khai báo</H3>
<a href="http://localhost:8080/setting/showForm"><button>Thêm mới</button></a>
</div>
<container class="row">

    <div class="row">
        <table class="table table-hover table-striped" id="trung">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Tên</th>
                <th class="text-center">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${personList}" varStatus="stt">
                <tr>
                    <td>${stt.count}</td>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td class="text-center">
                        <a href="/setting/updateList?id=${person.id}">
                            Update

                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</container>

</body>
</html>
