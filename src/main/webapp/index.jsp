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
        <h1>Фінальний проєкт до модуля 3</h1>
    </div>
    <div class="card-body">
        <blockquote class="blockquote mb-0">
            <p>Проект було створено по макету завдання.</p>
        </blockquote>
    </div>
    <div >
        <form class="card-header" action="http://localhost:8080/start" method="get">
            <br>
            <label for="nicNameStart">Nicknames:</label>
            <input type="text" id="nicNameStart" name="nicName" required>
            <br>
            <input class="btn btn-primary" type="submit" value="Start">
        </form>
    </div>
</div>

</body>
</html>