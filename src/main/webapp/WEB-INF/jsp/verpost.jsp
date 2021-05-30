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


<section class="post-content-section">
    <div class="container">

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 post-title-block">

                <h1 class="text-center">${post.titol}</h1>
                <ul class="list-inline text-center">
                    <li>Date | ${post.date}</li>
                </ul>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 text-justify">
                ${post.cos}
            </div>
        </div>
    </div>
</section>

    <h1>Comments</h1>
        <div class="container justify-content-center mt-5 border-left border-right">
            <label for="nom">Deja tu comentario</label>
            <form class="form" action="/verpost?postid=${param.postid}" method="post">
                <div class="form-group mx-sm-3 mb-2">
                        <textarea class="form-control" required minlength="3" id="nom" name="nom" rows="3"></textarea>
                    </div>
                <button type="submit" class="btn btn-primary mb-2"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                </svg> Enviar</button>

            </form>

            <div class="d-flex justify-content-center py-2">


                    <div class="second py-2 px-2"> <span class="text1">${c.cos}</span>
                        <div class="d-flex justify-content-between py-1 pt-2">
                            <div><span class="text2">${c.username}</span></div>
                        </div>
                    </div>


            </div>

            <c:forEach var="c" items="${comments}">
            <div class="card">
                <h5 class="card-header"><img src="https://i.imgur.com/yTFUilP.jpg" alt="" class="rounded-circle" width="40" height="40"> ${c.username} </h5>
                <div class="card-body">
                    <p class="card-text">${c.cos}</p>
                </div>
            </div>
            <hr>
            </c:forEach>




</body>
</html>
