<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Medical Declaration</h2>
<form:form action="" modelAttribute="medical" method="post">
    <div>
        Tên:
        <form:input type="text" path="ten"/>
    </div>
    <br>
    <div>
        Năm Sinh:
        <form:input type="text" path="namSinh"/>
    </div>
    </div>
    <p>Giới Tính: </p>
    <form:select path="gioiTinh">
        <form:option value="Nam"/>Nam
        <form:option value="Nữ"/>Nữ
    </form:select>
    </div>
    <div>
        Quốc Tịch:
        <form:input type="text" path="quocTich"/>
    </div>
    <br>
    <div>
        Số CMND:
        <form:input type="text" path="cmnd"/>
    </div>
    <br>
    <div>
        Thông Tin Đi Lại:
        <form:radiobutton path="phuongTien"/>Tàu Bay
        <form:radiobutton path="phuongTien"/>Tàu Thuyền
        <form:radiobutton path="phuongTien"/>Ô Tô
        <form:radiobutton path="phuongTien"/>Khác
    </div>
    <br>
    <div>
        Số hiệu phương tiện
        <form:input type="text" path="bienSo"/>
    </div>
    <div>
        Số ghế
        <form:input type="text" path="soGhe"/>
    </div>
    <br>
    <div>
        Ngày khời hành:
        <form:input type="text" path="ngayKhoiHanh"/>
    </div>
    <div>
        Ngày kết thúc:
        <form:input type="text" path="ngayKetThuc"/>
    </div>
    <div>
        Trong vòng 14 ngày có đi đâu không:
        <form:input type="text" path="thanhPho"/>
    </div>
    <div>
        <input type="submit" value="Gửi tờ khai">
    </div>
</form:form>
</body>
</html>
