<%@ page import="java.util.ResourceBundle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table border='1' style='display:flex; justify-content:center; width:100%; border-collapse:collapse;'>
  <tr style='border: 3px solid teal;'>
    <td style='border: 3px solid teal;'><b><%= ((ResourceBundle) request.getAttribute("res")).getString("owner") %></b></td>
    <td style='border: 3px solid teal;'><b><%= ((ResourceBundle) request.getAttribute("res")).getString("car") %></b></td>
    <td style='border: 3px solid teal;'><b><%= ((ResourceBundle) request.getAttribute("res")).getString("date") %></b></td>
    <td style='border: 3px solid teal;'><b><%= ((ResourceBundle) request.getAttribute("res")).getString("number") %></b></td>
  </tr>
  <%-- Данные об автомобилях. Это можно заполнить, используя данные из CSV или других источников --%>
  <tr style='border: 3px solid teal;'>
    <td style='border: 3px solid teal;'>Иван</td>
    <td style='border: 3px solid teal;'>Toyota</td>
    <td style='border: 3px solid teal;'>2021-01-01</td>
    <td style='border: 3px solid teal;'>A123BC</td>
  </tr>
  <tr style='border: 3px solid teal;'>
    <td style='border: 3px solid teal;'>Мария</td>
    <td style='border: 3px solid teal;'>Ford</td>
    <td style='border: 3px solid teal;'>2022-05-15</td>
    <td style='border: 3px solid teal;'>B456CD</td>
  </tr>
</table>
