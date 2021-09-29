<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        body{
            margin: 0;
            background: url(https://st3.depositphotos.com/2885805/12847/v/950/depositphotos_128479268-stock-illustration-mathematics-science-concept.jpg) no-repeat center;
        }

    </style>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-3">

            <a class="btn btn-primary" href="/authorization" role="button">Authorization</a>

            <a class="btn btn-primary" href="/registration" role="button">Registration</a>

        </div>
    </div>
</div>


<p>${requestScope.message}</p>
</body>
</html>
