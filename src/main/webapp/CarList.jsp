<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%= request.getAttribute("title") %></title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String car = request.getParameter("car");
    String lang = request.getParameter("lang");

    if ((!"ru".equalsIgnoreCase(lang) && !"en".equalsIgnoreCase(lang))) {
        RequestDispatcher dispatcher = (RequestDispatcher) request.getServletContext().getRequestDispatcher("/ErrorManager.jsp");
        try {
            dispatcher.forward((ServletRequest) request, (ServletResponse) response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        return;
    }

    ResourceBundle res = ResourceBundle.getBundle("/cars", "en".equalsIgnoreCase(lang) ? Locale.ENGLISH : Locale.getDefault());
    request.setAttribute("title", res.getString("title"));
    request.setAttribute("res", res);
    request.setAttribute("carFilter", car);
%>

<h1><%= res.getString("title") %></h1>

<%@ include file="ListCarsData.jsp" %>

</body>
</html>
