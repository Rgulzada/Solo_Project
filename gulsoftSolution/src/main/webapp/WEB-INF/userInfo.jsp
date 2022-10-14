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
<div class="info-container">
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
			<h2>Welcome ${user.name} </h2>
		</div>
		<div class="logcontent">
			<div class="regbox">	
			 <h3>Add Your Resume Manually!</h3><br />
			 
				<a href="/informations/new"><input type="button" class="submit-btn" value="Build Your CV" /></a>
			
				<!--  Here you will build your Resume Form -->
				
				<table>
				<c:forEach var="information" items="${assignedInformations}">
					<tr>
						<td><c:out value="${information.name}" /></td>
						<td><c:out value="${information.lead.lastname}" /></td>
						<td><c:out value="${information.summary}" /></td>
						<td><c:out value="${information.skills}" /></td>
					</tr>	
				</c:forEach>
				</table>
			</div>
			<div class="uploadbox">
				<h3>Upload</h3>
				<form action="post" class="uploadForm">
					  <input type="file" id="myfile" name="myfile">
					  <p>Upload your resume in word/.pdf/img(.jpg,.png) formats only.</p>
					  
					  <input type="submit" class="submit-btn" value="upload" />
				</form>
				
				<!--  here your upload file will show-->
				
				
			</div>
			
		</div>
	</div>
</div>	
</body>
</html>