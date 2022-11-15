package com.example.project1.controller;

import com.example.project1.model.DishDAO;
import com.example.project1.model.Dish;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ArrayList<Dish> dishes = DishDAO.instance.getDishes();

        request.setAttribute("dishes", dishes);
        request.getRequestDispatcher("dishes.jsp").forward(request, response);
    }

    public void destroy() {
    }
}