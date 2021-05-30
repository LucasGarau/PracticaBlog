<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/">Blogs</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/selectorforo">Selector Blog<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/adduser">Registrar</a>
            </li>
            <c:if test="${user.getId() != null}">

                <li class="nav-item">
                    <a class="nav-link" href="/selectorforoprivate">Blogs de ${user.getNom()}</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/addblog">Crear Blog</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/logout">Salir</a>
                </li>
            </c:if>

        </ul>
    </div>
</nav>

<h1>Setup de Usuario root</h1>


<form action="/setup" method="post" class="container">

    <c:if test="${not empty noerror}">
        <h3>Can't add car</h3>
    </c:if>


    <c:if test="${root == null}">
    <div class="form-group">
        <label for="nom">Nombre:</label>
        <input type="text" class="form-control" id="nom" name="nom" minlength="3" maxlength="20" required readonly value="root">
    </div>
    <div class="form-group">
        <label for="pass">Contrasenya( Entre 5 y 25 con Mayuscula,miniscula y numero):</label>
        <input type="password" class="form-control" id="pass" name="pass"  required minlength="5" maxlength="25" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">

    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</c:if>

<c:if test="${root.id != null}">

    <div class="alert alert-info" role="alert">
       El setup de el usurio root ya esta acabado!.
    </div>
</c:if>
</body>
</html>
