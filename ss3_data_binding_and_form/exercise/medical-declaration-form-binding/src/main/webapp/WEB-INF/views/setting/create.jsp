<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>TỜ KHAI Y TẾ</title>
</head>
<body>

<form:form method="POST" action="save" modelAttribute="medical" cssStyle="text-align: center">
    <H4>TỜ KHAI Y TẾ</H4>
    <h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG,THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h6>
    <h9 style="color: red" >Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h9>

    <fieldset>
        <table>
            <tr>
                <td>Họ tên (ghi chữ IN HOA)<sup>*</sup> <br>
                <form:input path="name"/></td>
            </tr>
            <tr>
                <td>Năm Sinh<sup>*</sup><br>
                <form:select path="year" items="${year}"/></td>
                <td>Giới Tính<sup>*</sup><br>
                <form:radiobuttons path="gender" items="${gender}"/></td>
                <td>Quốc Tịch<sup>*</sup><br>
                <form:select path="nationality" items="${nationality}"/></td>
            </tr>
            <tr>
                <td>Số Hộ Chiếu Hoặc CMND Hoặc Giấy Thông Hành Hợp Pháp Khác<sup>*</sup><br>
                <form:input path="idCard"/></td>
            </tr>
            <tr>
                <td>Thông Tin Đi Lại<sup>*</sup><br>
                <form:radiobuttons path="informationVehicle" items="${informationVehicle}"/></td>
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
                    <form:select path="startDay" items="${day}"/>
                    <form:select path="startMonth" items="${month}"/>
                    <form:select path="startYear" items="${year}"/>
                </td>
            </tr>
            <tr>
                <td>
                    Ngày kết thúc  <sup>*</sup>
                    <form:select path="endDay" items="${day}"/>
                    <form:select path="endMonth" items="${month}"/>
                    <form:select path="endYear" items="${year}"/>
                </td>
            </tr>
            <tr>
                <td>Trong 14 Ngày Qua Anh/Chị Có Đến Những Tỉnh/Thành Phố Nào?<sup>*</sup><br>
                    <form:textarea path="info"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"/></td>
                <td><input type="reset" value="Cancel"/></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>