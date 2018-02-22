<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Remove Confirmation</title>
	</head>
	<body>
	    Are you sure that you want to remove this?
	    
		<form action="deleteConsole" method="post">
			<input type="text" value="${name}">
			<input type="submit" value="Si">
		</form>
		
		<form action="deleteVideogame" method="post">
			<input type="text" value="${title}">
			<input type="submit" value="Si">
		</form>
	
	</body>
</html>