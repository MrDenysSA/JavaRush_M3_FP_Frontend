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
    <script defer src="<c:url value="/static/script.js"/>"></script>
</head>
<body>

<div>
    <form id="startButton">
        <p class="p-3"><%= request.getAttribute("question") %>
        </p>

        <p>
            <input type="radio" name="answer" value="1" required>
            <label><%= request.getAttribute("answer1") %>
            </label>
            <br>
            <input type="radio" name="answer" value="2" required>
            <label><%= session.getAttribute("answer2") %>
            </label>
        </p>
        <br>
        <input type="submit" name="submit" value="ВІДПОВІСТИ">
        <br>
    </form>
</div>

<div class="progress-container">
    <div class="progress-bar" id="progressBar"></div>
</div>

<div>
    <p>
    <h2>Statistics</h2></p>
    <p>IP Address:
        <nobr id="ipOutput"></nobr>
    </p>
    <p>Nicknames: <%= request.getAttribute("nicknames") %>
    </p>

    <%--    Нужно исправить щетчик? Прикрутить еще один щетчик из сервера которій будет считать цикли--%>
    <p>Game counter:
        <nobr id="gameCounter"></nobr><%= request.getAttribute("amountGames")%>
    </p>
</div>

<div>
    <p id="counterQuestion"><%= request.getAttribute("counter")%>
    </p
</div>

</body>
</html>