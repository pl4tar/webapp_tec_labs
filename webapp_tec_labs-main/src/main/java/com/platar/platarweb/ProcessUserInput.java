package com.platar.platarweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ProcessUserInput", value = "/ProcessUserInput")
public class ProcessUserInput extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получение данных из формы
        String username = request.getParameter("username");
        String color = request.getParameter("color");

        // Сохранение данных в Cookie
        Cookie nameCookie = new Cookie("username", username);
        Cookie colorCookie = new Cookie("color", color);
        nameCookie.setMaxAge(7 * 24 * 60 * 60); // 7 дней
        colorCookie.setMaxAge(7 * 24 * 60 * 60); // 7 дней
        response.addCookie(nameCookie);
        response.addCookie(colorCookie);

        // Сохранение данных в сессии
        HttpSession session = request.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 0;
        }
        session.setAttribute("visitCount", ++visitCount);
        session.setAttribute("lastVisit", new Date().toString());

        // Перенаправление на JSP для отображения данных
        response.sendRedirect("DisplayData.jsp");
    }
}