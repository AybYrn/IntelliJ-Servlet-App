package com.example.project1.controller;

import com.example.project1.model.Dish;
import com.example.project1.model.DishDAO;
import com.example.project1.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;


@WebServlet(name = "CookBookServlet", value = "/CookBookServlet")
@MultipartConfig(
        fileSizeThreshold = 1,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*11
)
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
        try {
            String name_of_dish = request.getParameter("nameofdish");
            System.out.println("Name of dish" + name_of_dish);
            int rate = Integer.parseInt(request.getParameter("rate"));
            System.out.println("Rate: " + rate);
            String ingredients = request.getParameter("ingredients").trim();
            System.out.println("Ingredients" + ingredients);
            String instructions = request.getParameter("instructions").trim();
            System.out.println("Instructions" + instructions);

            Part filepart = request.getPart("photo");
            String filename = filepart.getSubmittedFileName();
            System.out.println("File name" + filename);
            filepart.write("C:\\Users\\Lenovo\\eclipse-workspace\\CookBookApp\\src\\main\\webapp\\assets\\" + filename);
            System.out.println("File name" + filename);

            if (!name_of_dish.equals("") && !ingredients.equals("") && !instructions.equals("") && !filename.equals("")){

                HttpSession session = request.getSession();
                User u = (User) session.getAttribute("user");
                Dish d = DishDAO.instance.insertDish(u.getUser_id(), name_of_dish, u.getUser_name(), ingredients, instructions, filename, rate);

                ArrayList<Dish> dishes = DishDAO.instance.getDishes(u.getUser_id());

                request.setAttribute("dishes", dishes);
                request.getRequestDispatcher("dishes.jsp").forward(request, response);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
