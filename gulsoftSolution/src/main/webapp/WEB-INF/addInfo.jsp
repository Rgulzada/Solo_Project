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
			 
				<form:form action="/informations/new" method="post" modelAttribute="information" class="loginform">
					<div class="info-holder">
						<label for="name">FirstName</label>
						<form:errors path="name" class="text-danger"/>
						<form:input path="name" type="text" placeholder="First Name" />
						
						<label for="lastname">LastName</label>
						<form:errors path="lastname" class="text-danger"/>
						<form:input path="lastname" type="text" placeholder="Last Name" />
					</div>
					<div>
						<label>Summary about yourself</label><br />
						<form:errors path="summary" class="text-danger"/>
						<form:textarea path="summary" placeholder="Tell us about yourself..."></form:textarea>
					</div>
					<div class="select-box">
						<label>Skills</label><br />
						<form:errors path="skills" class="text-danger"/>
						  	<form:select path="skills" id="skil" size="3">
							    <option value="html">HTML</option>
							    <option value="css">CSS</option>
							    <option value="jsc">JavaScript</option>
							    <option value="work">Teamwork</option>
							    <option value="com">Communication</option>
							    <option value="jQ">jQuery</option>
						    </form:select>
					</div>
					
				  	<div>
						<input type="submit" class="submit-btn" value="Submit" />
						
						<input type="reset" value="Clear" class="reset-btn" />
					</div>
					
				</form:form>
				
			</div>
		</div>
	</div>
</div>	
</body>
</html>