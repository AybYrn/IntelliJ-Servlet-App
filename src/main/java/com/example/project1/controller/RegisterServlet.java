package com.example.project1.controller;

import com.example.project1.model.Dish;
import com.example.project1.model.DishDAO;
import com.example.project1.model.User;
import com.example.project1.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");

        HttpSession session = request.getSession();
        User user = UserDAO.instance.registerUser(userName, email, password);

        if(user != null){
            session.setAttribute("user", user);
            ArrayList<Dish> dishes = DishDAO.instance.getDishes();

            request.setAttribute("dishes", dishes);
            request.getRequestDispatcher("dishes.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
