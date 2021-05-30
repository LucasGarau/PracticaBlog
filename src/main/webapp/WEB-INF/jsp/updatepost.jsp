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

<h1>Update Post</h1>
<form action="/updatepost" method="post" class="container">
    <div class="form-group">
        <label for="titol">Titulo Post:</label>
        <textarea type="text" required minlength="3" class="form-control" id="titol" name="titol">${post.titol}</textarea>
    </div>
    <div class="form-group">
        <label for="cos">Cuerpo Post:</label>
        <textarea type="text" required minlength="3" class="form-control" id="cos" name="cos" rows="30">${post.cos}</textarea>
    </div>

    <div class="form-group">
        <input type="hidden" class="form-control" id="blogid" name="blogid" value=${param.blogid}>
    </div>

    <div class="form-group">
        <input type="hidden" class="form-control" id="postid" name="postid" value=${param.postid}>
    </div>

    <input type="hidden" name="_csrftoken" id="_csrftoken" value="${csrfToken}">

    <button type="submit" class="btn btn-default">Submit</button>
</form>

</body>
</html>
