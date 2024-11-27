package com.platar.platarweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String car = request.getParameter("car");

        // Проверка данных
        if (car == null || car.trim().isEmpty()) {
            request.getRequestDispatcher("/ErrorForm.jsp").forward(request, response);
        } else {
            request.setAttribute("carName", car);
            request.getRequestDispatcher("/CarResult.jsp").forward(request, response);
        }
    }
}
