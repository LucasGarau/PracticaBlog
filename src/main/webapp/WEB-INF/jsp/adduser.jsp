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

<h1>Registro Usuario</h1>

<c:if test="${not empty noerror}">
    <h3>Can't add car</h3>
</c:if>
<form action="/adduser" method="post" class="container">
    <div class="form-group">
        <label for="nom">Nombre:</label>
        <input type="text" class="form-control" id="nom" name="nom" minlength="3" maxlength="20" required>
    </div>
    <div class="form-group">
        <label for="pass">Contrasenya( Entre 5 y 25 con Mayuscula,miniscula y numero):</label>
        <input type="password" class="form-control" id="pass" name="pass"  required minlength="5" maxlength="25" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">

    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

<c:if test="${messages != null}">
    <div class="alert alert-primary" role="alert">
            ${messages}
    </div>
</c:if>

</body>
</html>
