<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Форма поиска автомобиля</title>
</head>
<body>
<h2>Введите марку автомобиля для поиска</h2>
<form action="http://localhost:8006/platarweb_war/CarServlet" method="post">
    <label for="car">Марка автомобиля:</label>
    <input type="text" id="car" name="car" required>
    <button type="submit">Поиск</button>
</form>
</body>
</html>
