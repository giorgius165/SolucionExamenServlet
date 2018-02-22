<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of Videogames</title>
	</head>
	<body>
		<form action="updateVideogameList" method="post">
			<input type="submit" value="ver listado">
		</form>
	
		<table border="1">
			<thead>
				<tr>
					<td>Title</td>
					<td>Age</td>
					<td>Release date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="videogame" items="${videogames}">
					<tr>
						<td><c:out value="${videogame.title}" /></td>
						<td><c:out value="${videogame.age}" /></td>
						<td><c:out value="${videogame.reldate}" /></td>
						<td><a href="/deleteVideogame?title=${videogame.title}">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<select>
			<c:forEach var="videojuego" items="${videojuegos}">
				<option value="${videojuego.titulo}">${videojuego.titulo}</option>
			</c:forEach>
		</select>
	</body>
</html>