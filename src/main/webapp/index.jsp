<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>WELCOME</title>

        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" />
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
        <script src="./js/bootstrap.bundle.min.js"></script>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>--%>

</head>
<body class="text-center" data-new-gr-c-s-check-loaded="14.1085.0" data-gr-ext-installed="">

<main class="form-signin">

    <div class="row">
        <div class="col">
            <form action="/LoginServlet" method="POST">
                <h1 class="h3 m-5 fw-normal fw-bold" style="color: orangered">Sign in</h1>

                <div class="form-floating mb-2">
                    <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mt-3" style="color: orangered">
                    <label>
                        <input type="checkbox" name="rememberMeCB" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-light btn-outline-dark fw-bold" type="submit">Sign in</button>
            </form>
        </div>
        <div class="col-1">
            <!--<div class="vr" style="height: 100%; width: 3px; color: #ffc107; border: 1px solid orangered; box-shadow: 0px 0px 8px orangered ;"></div>-->
        </div>
        <div class="col">
            <form action="/RegisterServlet" method="POST">
                <h1 class="h3 m-5 fw-normal fw-bold" style="color: orangered">Register</h1>

                <div class="form-floating mb-2">
                    <input type="text" name="userName" class="form-control" id="name" placeholder="name">
                    <label for="name">Name</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
                    <label for="email">Email address</label>
                </div>
                <div class="form-floating mb-2">
                    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                    <label for="password">Password</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="rePassword" class="form-control" id="repassword" placeholder="rePassword">
                    <label for="repassword">Repeat Password</label>
                </div>

                <button class="w-100 btn btn-lg btn-light btn-outline-dark fw-bold" type="submit">Register</button>
            </form>
        </div>

    </div>
</main>

</body>
</html>