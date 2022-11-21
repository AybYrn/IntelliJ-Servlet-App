<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/15/2022
  Time: 9:20 PM
  To change tdis template use File | Settings | File Templates.
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
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
<h2 class="display-6 text-warning ms-4">Welcome <span class="text-success lead fw-bolder">${sessionScope.user.user_name}</span></h2>
<div class="d-flex justify-content-between">
    <div class="w-25 d-inline-flex">
        <!-- Button trigger modal -->
        <a type="button" class="navbar-brand ms-4 text-uppercase text-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
            <i class="bi bi-plus-lg"></i>
            New Dish
        </a>

        <!-- Modal -->
        <div class="modal fade w-100" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Insert a Dish</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <table class="table table-striped">
                            <tr>
                                <td class="text-warning">Name of the Dish: </td>
                                <td><input type="text" name="nameofdish" id="nameofdish"></td>
                            </tr>
                            <tr>
                                <td class="text-warning">Enter Your Name: </td>
                                <td><input type="text" name="username" id="username"></td>
                            </tr>
                            <tr>
                                <td class="text-warning">Rate: </td>
                                <td><input type="text" name="rate" id="rate"></td>
                            </tr>
                            <tr>
                                <td class="text-warning">Ingredients: </td>
                                <td><textarea name="ingredients" id="ingredients" cols="50" rows="10"></textarea></td>
                            </tr>
                            <tr>
                                <td class="text-warning">Instructions: </td>
                                <td><textarea name="instructions" id="instructions" cols="50" rows="10"></textarea></td>
                            </tr>

                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-outline-light" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-warning btn-outline-light">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <a type="button" class="navbar-brand ms-4 text-uppercase text-dark" href="/CookBookServlet">
                <i class="bi bi-journals"></i>
                See All Dishes
            </a>
        </div>
    </div>
    <a type="button" class="navbar-brand ms-4 text-uppercase text-dark" href="/LogoutServlet">
        <i class="bi bi-door-open"></i>
        Log out
    </a>
</div>
    <div class="row row-cols-1 row-cols-md-3 g-3 justify-content-center bg-light mt-1">

        <c:forEach items="${dishes}" var="dishes">
            <div class="col-4 m-2 p-2 card border-warning w-25">
                <img src="./assets/<c:out value="${dishes.photo}"/>" class="card-img-top" style=" max-height: 100%">
                <div class="card-body">
                    <h5 class="card-title">
                        <c:out value="${dishes.dish_name}" />
                        <c:out value="${dishes.number_of_rate}" />
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
<a type="button" class="navbar-brand m-4 text-uppercase text-dark" href="/LoginServlet">
    <i class="bi bi-arrow-left"></i>
    Back To My Dishes
</a>
</body>
</html>
