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
<form action="/telephone">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-3">

                <a class="btn btn-primary" href="/addTelephone" role="button">Add phone</a>

                <a class="btn btn-primary" href="/removeTelephone" role="button">Remove</a>

                <a class="btn btn-primary" href="/showAllTelephones" role="button">Show all</a>

                <a class="btn btn-primary" href="/updateTelephone" role="button">Update</a>
                <br>
                <a class="btn btn-primary" href="/calculation" role="button">Back to calculator</a>

            </div>
        </div>
    </div>
</form>

<p>${requestScope.message}</p>
</body>
</html>
