<%@ page import="com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <style>
        div {
            text-align: center;
            padding: 50px;
        }

        a {
            font-size: 20px;
            text-decoration: none;
            color: black;
            padding:10px 20px;
            border: 1px solid black;
            border-radius: 8px;
            display: inline-block;
            margin-bottom: 10px;
            transition: all 0.4s ease;
        }

        a:hover {
            background: black;
            color: white;
        }

        h1 {
            padding: 20px;
        }
    </style>
</head>
<body>

<div>
    <h1>Của hàng của bình</h1>
    <a href="<%=request.getContextPath()%>/Home">Xem Sản Phẩm</a> <br>
    <a href="<%=request.getContextPath()%>/view/addProduct.jsp">Thêm Sản Phẩm</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>