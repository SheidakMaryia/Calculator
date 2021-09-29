<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 04.08.2021
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body style="background: #f1cfd5">
<jsp:include page="_header.jsp"/>
<h2>History of operations:</h2>
<form action="/history">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">num1</th>
            <th scope="col">num2</th>
            <th scope="col">result</th>
            <th scope="col">operation</th>
            <th scope="col">user</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.history}" var="operation">
            <tr>
                <td>${operation.num1}</td>
                <td>${operation.num2}</td>
                <td>${operation.result}</td>
                <td>${operation.typeOfOperation}</td>
                <td>${operation.user.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn btn-primary" href="/calculation" role="button">Back to calculator</a>

</form>
</body>
</html>
