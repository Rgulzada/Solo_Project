<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
	<title></title>
</head>
<body>
<div class="container">
<div id="menubar">
		<div class="menu">
			<div id="logo-menu">
				<a href="#"><img src="images/gulsoft.png" alt="logo"></a>
			</div>
			<div class="row-menu">
				<a href="/logout"><button class="contact-butt">Log Out</button></a>
			</div>
			<div class="box-bar">
				Applied Positions
			</div>
		</div>
	</div>
	<div class="content-login">
		<div class="logcontent">
			<h2>Welcome</h2>
		</div>
		<div class="logcontent">
			<p><a href="/dashboard">Dashboard</a></p>
		</div>
		<div class="logcontent">
		
			<div class="regbox">	
			 <h3>Fill out the form!</h3><br />
		</div>
		</div>
	</div>
</div>
</body>
</html>