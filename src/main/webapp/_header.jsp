<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 22.08.2021
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <style>
        a{
            text-decoration: none;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
    <div class="container-fluid">
        <h4 style="font: 20px Baskerville Old Face" class="navbar-brand">Calculator</h4>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div style="background: pink" class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <c:if test="${sessionScope.user == null}">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello Guest</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello ${sessionScope.user.name}</a>
                    </c:if>
                </li>
            </ul>

            <c:if test="${sessionScope.user != null}">
                <div class="dropdown text-end me-5">
                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://pngicon.ru/file/uploads/1303507907_User_Green-128x128.png"
                             alt="mdo" width="45" height="45" class="rounded">
                    </a>
                    <ul class="dropdown-menu text-big" aria-labelledby="dropdownUser1" style="">
                        <li><a href="/telephone" class="nav-link px-2 link-dark">Telephones</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a href="/address" class="nav-link px-2 link-dark">Addresses</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a href="/logout" class="nav-link px-2 link-dark">Log out</a></li>

                    </ul>
                </div>
            </c:if>

        </div>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
