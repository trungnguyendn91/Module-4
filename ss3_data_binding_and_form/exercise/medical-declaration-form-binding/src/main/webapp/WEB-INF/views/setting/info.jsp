<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/16/2022
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TỜ KHAI Y TẾ</title>
</head>
<body style="text-align: center">
<H4>TỜ KHAI Y TẾ</H4>
<h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG,THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h6>
<h9 style="color: red" >Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h9>
<table>
    <tr>
        <td>Họ tên (ghi chữ IN HOA)<br>
        ${declaration.name}</td>
    </tr>
    <tr>
        <td>Năm Sinh<sup>*</sup><br>
            ${declaration.year}</td>
        <td>Giới Tính<sup>*</sup><br>
            ${declaration.gender}</td>
        <td>Quốc Tịch<sup>*</sup><br>
            ${declaration.nationality}</td>
    </tr>
    <tr>
        <td>Số Hộ Chiếu Hoặc CMND Hoặc Giấy Thông Hành Hợp Pháp Khác<sup>*</sup><br>
           ${declaration.idCard}</td>
    </tr>
    <tr>
        <td>Thông Tin Đi Lại<sup>*</sup><br>
            ${declaration.informationVehicle}</td>
    </tr>
    <tr>
        <td>Số Hiệu Phương Tiện <br>
            ${declaration.vehicleNumber}</td>
        <td>Số Ghế
           ${declaration.seatNumber}</td>
    </tr>
    <tr>
        <td>
            Ngày khởi hành  <sup>*</sup>
            ${declaration.startDay}
            ${declaration.startMonth}
            ${declaration.startYear}
        </td>
    </tr>
    <tr>
        <td>
            Ngày kết thúc  <sup>*</sup>
            ${declaration.endDay}
            ${declaration.endMonth}
            ${declaration.endYear}
        </td>
    </tr>
</table>
</body>
</html>
