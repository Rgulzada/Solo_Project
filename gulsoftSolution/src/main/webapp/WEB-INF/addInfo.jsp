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
				<button class="contact-butt">Log Out</button>
			</div>
			<div class="box-bar">
				Applied Positions
			</div>
		</div>
	</div>
	<div class="content-login">
		<div class="logcontent">
			<h2>Welcome ${user.firstname} </h2>
		</div>
		<div class="logcontent">
			<div class="regbox">	
			 <h3>Fill out the form!</h3><br />
				<form class="loginform">
					<div class="info-holder">
						<label for="fistname">FirstName</label>
						<input type="text" placeholder="First Name" />
						<label for="lastname">LastName</label>
						<input  type="text" placeholder="Last Name" />
					</div>
					<div>
						<label>Summary about yourself</label><br />
						<textarea placeholder="Tell us about yourself..."></textarea>
					</div>
					<div class="select-box">
						<label for="cars">Skills</label><br />
						  	<select name="cars" id="cars" multiple size=2>
							    <option value="volvo">HTML</option>
							    <option value="saab">CSS</option>
							    <option value="opel">JavaScript</option>
							    <option value="audi">Teamwork</option>
							    <option value="opel">Communication</option>
							    <option value="audi">jQuery</option>
						    </select>
					</div>
					
				  	<div>
						<input type="button" class="submit-btn" value="Submit" />
					</div>
					
				</form>	
				
			</div>
		</div>
	</div>
</div>	
</body>
</html>