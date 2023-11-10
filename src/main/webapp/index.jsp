<%--
  Created by IntelliJ IDEA.
  User: OleksandrJR
  Date: 10/11/23
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>M3 JSP Final project</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>

<div class="card">
    <div class="card-header">
        <h1>Final project hello page</h1>
    </div>
    <div class="card-body">
        <blockquote class="blockquote mb-0">
            <p>
                lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi.
            </p>
            <a class="btn btn-primary" href="start">Start quest</a>
        </blockquote>
    </div>
</div>

</body>
</html>
