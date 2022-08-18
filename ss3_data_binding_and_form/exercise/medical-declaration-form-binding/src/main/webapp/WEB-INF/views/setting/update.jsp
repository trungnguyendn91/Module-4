<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/17/2022
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form method="POST" action="update" modelAttribute="person" cssStyle="text-align: center">
<H4>TỜ KHAI Y TẾ</H4>
<h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG,THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h6>
<h9 style="color: red" >Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h9>

<fieldset>
    <table>
        <tr>
            <td>Họ tên (ghi chữ IN HOA)<sup>*</sup> <br>
                <form:hidden path="id"></form:hidden>
                <form:input path="name" items="" /></td>
        </tr>
        <tr>
            <td>Năm Sinh<sup>*</sup><br>
                <form:select path="year" items="${yearList}"/></td>
            <td>Giới Tính<sup>*</sup><br>
                <form:radiobuttons path="gender" items="${genderList}"/></td>
            <td>Quốc Tịch<sup>*</sup><br>
                <form:select path="nationality" items="${nationList}"/></td>
        </tr>
        <tr>
            <td>Số Hộ Chiếu Hoặc CMND Hoặc Giấy Thông Hành Hợp Pháp Khác<sup>*</sup><br>
                <form:input path="idCard"/></td>
        </tr>
        <tr>
            <td>Thông Tin Đi Lại<sup>*</sup><br>
                <form:radiobuttons path="informationVehicle" items="${vehicleList}"/></td>
        </tr>
        <tr>
            <td>Số Hiệu Phương Tiện <br>
                <form:input path="vehicleNumber"/></td>
            <td>Số Ghế
                <form:input path="seatNumber"/></td>
        </tr>
        <tr>
            <td>
                Ngày khởi hành  <sup>*</sup>
                <form:select path="startDay" items="${dayList}"/>
                <form:select path="startMonth" items="${monthList}"/>
                <form:select path="startYear" items="${yearList}"/>
            </td>
        </tr>
        <tr>
            <td>
                Ngày kết thúc  <sup>*</sup>
                <form:select path="endDay" items="${dayList}"/>
                <form:select path="endMonth" items="${monthList}"/>
                <form:select path="endYear" items="${yearList}"/>
            </td>
        </tr>
        <tr>
            <td>Trong 14 Ngày Qua Anh/Chị Có Đến Những Tỉnh/Thành Phố Nào?<sup>*</sup><br>
                <form:textarea path="info"/></td>
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
