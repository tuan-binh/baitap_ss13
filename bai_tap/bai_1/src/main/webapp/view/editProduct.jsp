<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 02/08/2023
  Time: 3:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Home" method="post">
    <input type="hidden" value="${requestScope.data.id}" name="id">
    <label for="name">Name: </label> <br>
    <input type="text" value="${requestScope.data.name}" name="name" id="name" placeholder="name..."> <br>
    <label for="desc">Desc: </label> <br>
    <input type="text" value="${requestScope.data.description}" name="desc" id="desc" placeholder="description..."> <br>
    <label for="price">Price: </label> <br>
    <input  type="text" value="${requestScope.data.price}" name="price" id="price" placeholder="price..."> <br>
    <button type="submit" name="action" value="UPDATE">UPDATE</button>
</form>
</body>
</html>
