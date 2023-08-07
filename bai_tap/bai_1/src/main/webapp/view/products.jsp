<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 02/08/2023
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        table {
            margin: 50px auto;
        }

        div {
            text-align: center;
        }

        a {
            font-size: 20px;
        }

        form {
            text-align: center;
            margin: 10px;
        }

        input {
            font-size: 20px;
        }

        .flex {
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
<div>
    <h1>Sản Phẩm Của Chúng Tôi</h1>
    <a href="<%=request.getContextPath()%>/">Quay Lại</a>
</div>
<form action="<%=request.getContextPath()%>/Home" method="post">
    <input type="text" value="${textSearch}" name="search" placeholder="search here..."> <br>
    <select name="option" id="">
        <option value="STT">STT</option>
        <option value="NAME">NAME</option>
        <option value="PRICE">PRICE</option>
    </select> <br>
    <button name="action" value="SEARCH">Search</button>
</form>
<table border="10" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th colspan="3">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="p" varStatus="iterator">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>${p.price}</td>
            <td><a href="<%=request.getContextPath()%>/Home?action=DETAIL&id=${p.id}"><i class="fa-solid fa-eye"></i></a></td>
            <td><a href=<%=request.getContextPath()%>"/Home?action=EDIT&id=${p.id}"><i class="fa-solid fa-gear"></i></a></td>
            <td><a onclick="return confirm('Are you sure')" href="<%=request.getContextPath()%>/Home?action=DELETE&id=${p.id}"><i class="fa-solid fa-trash"></i>
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${empty textSearch}">
    <div class="flex">
        <a href="<%=request.getContextPath()%>/Home?action=PREV"><i class="fa-solid fa-angle-left"></i></a>
            <c:out value="${page}/${pages}"></c:out>
        <a href="<%=request.getContextPath()%>/Home?action=NEXT"><i class="fa-solid fa-angle-right"></i></a>
    </div>
</c:if>
</body>
</html>
