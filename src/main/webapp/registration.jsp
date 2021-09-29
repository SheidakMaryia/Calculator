<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 04.08.2021
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body style="background: #f1cfd5">
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <form action="/registration" method="post">
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="exampleInputName">
                </div>
                <div class="mb-3">
                    <label for="exampleInputLogin" class="form-label">Login</label>
                    <input type="text" name="login" class="form-control" id="exampleInputLogin">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Get Registration!</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
