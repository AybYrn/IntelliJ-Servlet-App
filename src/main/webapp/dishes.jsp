<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/15/2022
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dishes" scope="request" type="java.util.List<com.example.project1.model.Dish>"/>
<html>
<head>
    <title>DISHES</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" />

    <script src="./js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="row justify-content-center">
        <c:forEach items="${dishes}" var="dishes">
            <div class="col-4 m-3 p-2 card">
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
