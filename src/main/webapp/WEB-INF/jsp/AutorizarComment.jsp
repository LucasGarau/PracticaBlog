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

                <li>

                </li>

            </c:if>

        </ul>
    </div>
</nav>

    <h1>Autorizar Comentarios</h1>


            <c:forEach var="c" items="${comments}">
            <div class="card">
                <h5 class="card-header"> ${c.username} </h5>
                <div class="card-body">
                    <p class="card-text">${c.cos}</p>
                </div>
                <form class="form-inline" action="/autocomments" method="post">
                    <input type="hidden" class="form-control" id="commentid" name="commentid" value= ${c.id} >
                    <input type="hidden" class="form-control" id="blogid" name="blogid" value= ${param.id} >

                    <button type="submit" class="btn btn-primary mb-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-check" viewBox="0 0 16 16">
                            <path d="M10.854 7.854a.5.5 0 0 0-.708-.708L7.5 9.793 6.354 8.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                            <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z"/>
                        </svg>
                    </button>
                </form>
            </div>
            <hr>
            </c:forEach>
<c:if test="${comments.size() == 0}">

<div class="alert alert-info" role="alert">
    No hay comentarios por revisar
</div>
</c:if>



</body>
</html>
