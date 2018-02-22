<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of Consoles by brand</title>
	</head>
	<body>
		<form action=".." method="post">
			<select>
				<c:forEach var="console" items="${consoles}">
					<option value="${console.company}">${console.company}</option>
				</c:forEach>
			</select>
		</form>
	
		<table border="1">
			<thead>
				<tr>
					<td>Company</td>
					<td>Console</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ConsolaMarca" items="${marconsolas}">
					<tr>
						<td><c:out value="${ConsolaMarca.empresa}" /></td>
						<td><c:out value="${ConsolaMarca.nombre}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>