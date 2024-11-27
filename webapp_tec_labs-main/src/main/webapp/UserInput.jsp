<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Input Page</title>
</head>
<body>
<form action="ProcessUserInput" method="post">
  <label for="username">Имя пользователя:</label>
  <input type="text" id="username" name="username" required><br><br>

  <label for="color">Цвет страницы:</label>
  <select id="color" name="color">
    <option value="white">Белый</option>
    <option value="lightblue">Голубой</option>
    <option value="lightgreen">Зеленый</option>
    <option value="pink">Розовый</option>
  </select><br><br>

  <button type="submit">Сохранить</button>
</form>
</body>
</html>
