<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 03/08/2023
  Time: 3:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/Home">Quay Lại</a>
<h1>Đây là sản phẩm:
    ${data.name}</h1>
<p>${data.description}</p>
<p>${data.price}</p>
</body>
</html>
