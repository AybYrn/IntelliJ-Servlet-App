package com.example.project1.controller;

import com.example.project1.model.Dish;
import com.example.project1.model.DishDAO;
import com.example.project1.model.User;
import com.example.project1.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookie_email = null;
        String cookie_password = null;

        for(Cookie cookie : request.getCookies()){
            if(cookie.getName().equals("user_email")){
                cookie_email = cookie.getValue();
            }
            else if (cookie.getName().equals("user_password")){
                cookie_password = cookie.getValue();
            }
        }
        User user = null;

        if (cookie_email != null && cookie_password != null && (user = UserDAO.instance.checkUserPassword(cookie_email, cookie_password)) != null ){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            ArrayList<Dish> dishes = DishDAO.instance.getDishes(user.getUser_id());

            request.setAttribute("dishes", dishes);
            request.getRequestDispatcher("dishes.jsp").forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
            if(session.getAttribute("user") != null){
                ArrayList<Dish> dishes = DishDAO.instance.getDishes((int)session.getAttribute("user_id"));

                request.setAttribute("dishes", dishes);
                request.getRequestDispatcher("dishes.jsp").forward(request, response);
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        User user = UserDAO.instance.checkUserPassword(email, password);

        if(user != null){
            session.setAttribute("user", user);
            session.setAttribute("user_id", user.getUser_id());
            if (request.getParameter("rememberMeCB") != null){
                Cookie email_cookie = new Cookie("user_email", user.getUser_email());
                Cookie password_cookie = new Cookie("user_password", user.getUser_password());

                email_cookie.setMaxAge(Integer.MAX_VALUE);
                password_cookie.setMaxAge(Integer.MAX_VALUE);

                response.addCookie(email_cookie);
                response.addCookie(password_cookie);
            }
            ArrayList<Dish> dishes = DishDAO.instance.getDishes(user.getUser_id());

            request.setAttribute("dishes", dishes);
            request.getRequestDispatcher("dishes.jsp").forward(request, response);
        }
    }
}
