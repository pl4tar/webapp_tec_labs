<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Обработка ошибки</title>
</head>
<body>
<h3>Ошибка</h3>
<p>Необходимо указать параметр "lang" в формате "?lang=ru" или "?lang=en" в URL.<br>Пример: /CarList.jsp?lang=ru</p>
</body>
<% response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); %>
<script>
  window.location.reload();
</script>

</html>
