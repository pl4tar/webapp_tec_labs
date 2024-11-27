package com.platar.platarweb;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "carListServlet", value = "/car-list")
public class HelloServlet extends HttpServlet {

    private static final String CSV_FILE_PATH = "/WEB-INF/cars.csv";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Устанавливаем кодировку для чтения параметров запроса
        request.setCharacterEncoding("UTF-8");

        String filterCar = request.getParameter("car");
        String lang = request.getParameter("lang");

        if (lang == null || (!"ru".equalsIgnoreCase(lang) && !"en".equalsIgnoreCase(lang))) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Invalid lang parameter. Use 'ru' or 'en'.");
            return;
        }

        // Устанавливаем кодировку ответа
        response.setContentType("text/html;charset=UTF-8");

        // Выбор локализации
        ResourceBundle res = ResourceBundle.getBundle(
                "/cars", "en".equalsIgnoreCase(lang) ? Locale.ENGLISH : Locale.getDefault()
        );

        List<String[]> carsData = loadCarsData();

        if (filterCar != null && !filterCar.isEmpty()) {
            carsData = carsData.stream()
                    .filter(row -> row[1].equalsIgnoreCase(filterCar))
                    .collect(Collectors.toList());
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>");
            out.println(res.getString("title"));
            out.println("</title></head>");
            out.println("<body>");
            out.println("<h1>" + res.getString("title") + "</h1>");
            out.println("<table border='1' style='display:flex; justify-content:center; width:100%; border-collapse:collapse;'>");
            out.println("<tr style='border: 3px solid teal;'>");
            out.println("<th style='border: 3px solid teal;'>" + res.getString("owner") + "</th>");
            out.println("<th style='border: 3px solid teal;'>" + res.getString("car") + "</th>");
            out.println("<th style='border: 3px solid teal;'>" + res.getString("date") + "</th>");
            out.println("<th style='border: 3px solid teal;'>" + res.getString("number") + "</th>");
            out.println("</tr>");

            for (String[] row : carsData) {
                out.println("<tr style='border: 3px solid teal;'>");
                out.println("<td style='border: 3px solid teal;'>" + row[0] + "</td>");
                out.println("<td style='border: 3px solid teal;'>" + row[1] + "</td>");
                out.println("<td style='border: 3px solid teal;'>" + row[2] + "</td>");
                out.println("<td style='border: 3px solid teal;'>" + row[3] + "</td>");
                out.println("</tr>");
            }

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

    // Метод для загрузки данных из CSV файла
    private List<String[]> loadCarsData() throws IOException {
        List<String[]> data = new ArrayList<>();
        InputStream inputStream = getServletContext().getResourceAsStream(CSV_FILE_PATH);
        if (inputStream == null) {
            throw new FileNotFoundException("Файл " + CSV_FILE_PATH + " не найден");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(";"));
            }
        }

        return data;
    }
}
