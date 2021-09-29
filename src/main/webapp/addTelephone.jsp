<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add_telephone_number</title>
</head>
<body style="background: #f1cfd5">
<jsp:include page="_header.jsp"/>
<form action="/addTelephone" method="post">
    <label for="phoneNumber">Phone number</label>
    <input type="text" name="phoneNumber" required id="phoneNumber">

    <button>Submit</button>

    <br>
    <a class="btn btn-primary" href="/calculation" role="button">Back to calculator</a>
    <br>
    <a class="btn btn-primary" href="/logout" role="button">Log out</a>
    <br>
    <a class="btn btn-primary" href="/telephone" role="button">Back to phone menu</a>

</form>
<p>${message}</p>
</body>
</html>
