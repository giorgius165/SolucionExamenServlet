<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Videogames Form</title>
	</head>
	<body>
		<form action="addVideogame" method="post">
			<span>Title: </span>
			<input type="text" name="title"><br/>
			<span>Age: </span>
			<input type="text" name="age"> <br/>
			<span>Release Date:</span>
			<input type="text" name="reldate"><br/>
			<input type="submit">
		</form>
	</body>
</html>