<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body><null>
    <h1>Login</h1>

    <c:if test="${not empty noerror}">
    <h3>Login fallido</h3>
    </c:if>
    <form action="/login" method="post" class="container">
        <div class="form-group">
            <label for="nom">Name:</label>
            <input type="text" class="form-control" id="nom" name="nom">
        </div>
        <div class="form-group">
            <label for="pass">Pass:</label>
            <input type="password" class="form-control" id="pass" name="pass">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

<c:if test="${messages != null}">
    <div class="alert alert-primary" role="alert">
    ${messages.get(0)}
    </div>
</c:if>


</body>
</html>
