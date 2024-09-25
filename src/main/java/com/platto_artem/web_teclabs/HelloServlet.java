package com.platto_artem.web_teclabs;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    //    public void init() {
//        message = "Hello World!";
//    }
    public HelloServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Список книг</title></head>");
            out.println("<body>");
            out.println("<h1>Список книг читателя " + (name != null ? name :
                    "без имени") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Автор книги</b></td><td><b>Название книги </b></td><td><b>Прочитал</b></td></tr>");
            out.println("<tr><td>Булгаков</td><td>Мастер и Маргарита </td><td>Да</td></tr>");
            out.println("<tr><td>Пелевин</td><td>Чапаев и пустота </td><td>Нет</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}