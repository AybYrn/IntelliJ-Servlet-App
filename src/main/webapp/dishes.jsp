<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/15/2022
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dishes" scope="request" type="java.util.ArrayList<com.example.project1.model.Dish>"/>

<html>
<head>
    <title>DISHES</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" />
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>--%>
    <script src="./js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h2 class="text-uppercase text-center text-warning m-3 fw-lighter">WELCOME ${sessionScope.user.user_name} TO COOK BOOK</h2>
<a type="button" class="navbar-brand m-4 text-black text-uppercase"  href="insert.jsp">
    <i class="bi bi-plus-square-fill"></i>
    New Dish
</a>
<a type="button" class="navbar-brand m-4 text-black text-uppercase">
<i class="bi bi-journals"></i>
See All Dishes
</a>
    <div class="row row-cols-1 row-cols-md-3 g-4 justify-content-center bg-dark">

        <c:forEach items="${dishes}" var="dishes">
            <div class="col-4 m-3 p-2 card border-light">
                <img src="./assets/<c:out value="${dishes.photo}"/>" class="card-img-top" style=" max-height: 100%">
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${dishes.dish_name}" />    <c:out value="${dishes.number_of_rate}" />
    <%--                    <div class="ratings">--%>
    <%--                        <i class="bi bi-star"></i>--%>
    <%--                        <i class="bi bi-star"></i>--%>
    <%--                        <i class="fa fa-star rating-color"></i>--%>
    <%--                        <i class="fa fa-star rating-color"></i>--%>
    <%--                        <i class="fa fa-star"></i>--%>
    <%--                    </div>--%>
                        <c:out value="${dishes.avg_rate}"/>
                    </h5>
                    <p class="card-subtitle mb-2 text-muted">By <c:out value="${dishes.provided_by}" /></p>
                    <p class="card-text">
                        <span class="text-uppercase fw-bold">Ingredient</span>
                        <br/>
                        <c:forEach items="${dishes.ingredientArray}" var="ingredient">
                            <c:out value="${ingredient}" />
                            <br/>
                        </c:forEach>
                    </p>
                    <p class="card-text">
                        <span class="text-uppercase fw-bold">Instruction</span>
                        <br/>
                        <c:forEach items="${dishes.instructionArray}" var="instruction">
                            <c:out value="${instruction}" />
                            <br/>
                        </c:forEach>

                    </p>
                </div>
            </div>
        </c:forEach>
    </div>

</body>
</html>
