<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
  <title>Display Data</title>
</head>
<body style="background-color: <%= request.getParameter("color") %>">
<%
  // Получение данных из Cookie
  Cookie[] cookies = request.getCookies();
  String username = "Гость";
  String color = "Белый";

  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if ("username".equals(cookie.getName())) {
        username = cookie.getValue();
      } else if ("color".equals(cookie.getName())) {
        color = cookie.getValue();
      }
    }
  }

  // Получение данных из сессии
  Integer visitCount = (Integer) session.getAttribute("visitCount");
  String lastVisit = (String) session.getAttribute("lastVisit");
%>
<h1>Добро пожаловать, <%= username %>!</h1>
<p>Ваш цвет страницы: <%= color %></p>
<p>Вы посетили эту страницу <%= visitCount != null ? visitCount : 0 %> раз(а).</p>
<p>Последний визит: <%= lastVisit != null ? lastVisit : "Неизвестно" %></p>
</body>
</html>
