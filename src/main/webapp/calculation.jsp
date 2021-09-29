<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 04.08.2021
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body style="background: #f1cfd5">
<jsp:include page="_header.jsp"/>
<form action="/calculation" method="post">
    <label for="number1">Number 1</label>
    <input type="number" name="num1" required id="number1">
    <label for="number2">Number 2</label>
    <input type="number" name="num2" required id="number2">
    <select name="operation">
        <option value="addition">Addition</option>
        <option value="division">Division</option>
        <option value="multiplication">Multiplication</option>
        <option value="subtraction">Subtraction</option>
    </select>
    <button>Calculate</button>
    <p> Result: ${requestScope.result}</p>

    <a class="btn btn-primary" href="/history" role="button">History</a>
    <br>
    <a class="btn btn-primary" href="/logout" role="button">Log out</a>

</form>
</body>
</html>
