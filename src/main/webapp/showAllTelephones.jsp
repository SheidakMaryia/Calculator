<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body style="background: #f1cfd5">
<jsp:include page="_header.jsp"/>
<h2>History of operations:</h2>
<form action="/showAllTelephones">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">number</th>
            <th scope="col">user</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.allTelephones}" var="telephone">
            <tr>
                <td>${telephone.id}</td>
                <td>${telephone.number}</td>
                <td>${telephone.user.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a class="btn btn-primary" href="/calculation" role="button">Back to calculator</a>
    <br>
    <a class="btn btn-primary" href="/logout" role="button">Log out</a>
    <br>
    <a class="btn btn-primary" href="/telephone" role="button">Back to phone menu</a>

</form>
</body>
</html>
