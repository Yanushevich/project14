<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Авторизация</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" 
	crossorigin="anonymous">
</head>

<%
	String errorMsg = "";
	if (session.getAttribute("err") != null) {
		errorMsg = (String) session.getAttribute("err");
		
		session.removeAttribute("err");
	}

%>
<body>

<div class="container-fluid">
<div class="row">
<div 
	class="col-12 bg-dark text-light d-flex justify-content-center align-items-center"
	style="height: 100vh">
	<form action="register" method="post">
  <div class="form-group">
    <label>Имя пользователя</label>
    <input 
    	type="text" name="username" class="form-control">
  </div>
  <div class="form-group">
    <label>Пароль</label>
    <input 
    	type="password" name="password" class="form-control">
  </div>
  
  
  <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
  <a class="btn btn-primary" href="auth.jsp" role="button">У меня уже есть аккаунт</a>
  
  	<% if(errorMsg != ""){ %>
    <div class="alert alert-warning" role="alert">
  		<%= errorMsg %>
	</div>
	<% } %>
</form>

</div>
</div>
</div>

</body>
</html>