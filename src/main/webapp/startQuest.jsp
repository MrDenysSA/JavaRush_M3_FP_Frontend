<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Text Quest</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>

<h1 class="p-3">Start quest page</h1>

<p class="p-3"><%= request.getAttribute("greeting") %></p>

<p class="p-3"><%= request.getAttribute("requestAttribute") %></p>
<p class="p-3"><%= session.getAttribute("sessionAttribute") %></p>

</body>
</html>
