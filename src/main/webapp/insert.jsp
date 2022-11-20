<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/20/2022
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
      <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" />
<%--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
      <script src="./js/bootstrap.bundle.min.js"></script>
<%--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>--%>

</head>
<body class="bg-dark">
<table class="table table-dark table-striped w-50 m-2">
    <tr>
      <th scope="col">Name of The Dish: </th>
      <th scope="col"><input type="text" name="nameofdish" id="nameofdish"></th>
    </tr>
    <tr>
      <th scope="row">Enter Your Name: </th>
      <td><input type="text" name="username" id="username"></td>
    </tr>
    <tr>
      <th scope="row">Rate: </th>
      <td><input type="text" name="rate" id="rate"></td>
    </tr>
    <tr>
      <th scope="row">Ingredients: </th>
      <td><textarea name="ingredients" id="ingredients" cols="50" rows="20"></textarea></td>
    </tr>
    <tr>
      <th scope="row">Instructions: </th>
      <td><textarea name="instructions" id="instructions" cols="50" rows="20"></textarea></td>
    </tr>

  </table>
</body>
</html>
