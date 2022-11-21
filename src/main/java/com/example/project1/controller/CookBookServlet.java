package com.example.project1.controller;

import com.example.project1.model.Dish;
import com.example.project1.model.DishDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CookBookServlet", value = "/CookBookServlet")
public class CookBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Dish> dishes = DishDAO.instance.getDishes();
        HttpSession session = request.getSession();
        request.setAttribute("dishes", dishes);
        request.getRequestDispatcher("dishes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
