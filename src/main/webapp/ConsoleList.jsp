<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of Consoles</title>
	</head>
	<body>
		<form action="updateConsoleList" method="post">
			<input type="submit" value="ver listado" >
		</form>
		<br>
		<form action="updateConsoleOrder" method="post">
			<input type="submit" value="ordenar listado" >
		</form>
		<br>
		<table border="1" align="center">
			<thead>
				<tr>
					<td>Name</td>
					<td>Company</td>
				</tr>
			</thead>
			<tbody>		
				<c:forEach var="console" items="${consoles}">
					<tr>
						<td><c:out value="${console.name}" /></td>
						<td><c:out value="${console.company}" /></td>
						<td><a href="/deleteConsole?name=${console.name}">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
	</body>
</html>