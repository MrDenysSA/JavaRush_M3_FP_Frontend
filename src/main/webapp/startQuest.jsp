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
    <script src="<c:url value="/static/script.js"/>"></script>
</head>
<body>

<div>
    <form id="startButton">
        <p class="p-3"><%= request.getAttribute("question") %>
        </p>

        <p >
            <input  type="radio" id="q1" name="question" value="1" required>
            <label><%= request.getAttribute("requestAttribute") %>
            </label>
            <br>
            <input type="radio" id="q2" name="question" value="2" required>
            <label><%= session.getAttribute("sessionAttribute") %>
            </label>
        </p>
        <br>
        <input type="submit" name="submit" onclick="next()" value="ВІДПОВІСТИ">
        <br>
    </form>
</div>

<div class="progress-container">
    <div class="progress-bar" id="progressBar"></div>
    <button onclick="moveProgressBar()">Кнопка бара Тестовая</button>
</div>

<div>
    <p><h2>Statistics</h2></p>
    <p>IP Address: <nobr id="ipOutput"></nobr></p>
    <p>Nicknames: <%= request.getAttribute("nicknames") %> </p>

<%--    Нужно исправить щетчик --%>
    <p>Game counter: <nobr id="gameCounter"></nobr></p>

</div>

<div>
<p>Integer totalQuestions From JAVA:> <%= request.getAttribute("counter")%></p
</div>

</body>
</html>