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
	<title>GulSoft</title>
</head>
<body>
<div class="container">
	<div id="menubar">
		<div class="menu">
			<div id="logo-menu">
				<a href="#"><img src="images/gulsoft.png" alt="logo"></a>
			</div>
			<div class="row-menu">
				<button class="contact-butt">CONTACT US</button>
			</div>
			<div class="box-bar">
				<div class="bar1"></div>
				<div class="bar2"></div>
				<div class="bar3"></div>
			</div>
		</div>
	</div>
	<div class="content-login">
		<div class="logcontent">
			<h2>Wants to Join Our Team! </h2>
		</div>
		<div class="logcontent">
			<div class="regbox">	
			 <h2>Register</h2>
			 <p>Please fill in this form to create an account.</p>
				<form class="loginform">
				  <div class="form-container">
				    	<div>
						    <label for="fistname"><b>First Name</b></label>
						    <input type="text" placeholder="First Name" />
						</div>
						<div>
						    <label for="lastname"><b>Last Name</b></label>
						    <input type="text" placeholder="Last Name" >
						</div>
					    <div>
						    <label for="email"><b>Email</b></label>
						    <input type="text" placeholder="Email" />
						</div>
						<div>
						    <label for="psw"><b>Password</b></label>
						    <input type="password" placeholder="Password" />
						</div>
						<div>
						    <label for="psw-repeat"><b>Repeat Password</b></label>
						    <input type="password" placeholder="Repeat Password" />
						 </div>
					<p>By creating an account you agree to our <a href="#">Terms and Privacy</a>.</p>
					</div>
					<button type="submit" class="registerbtn">Register</button>
				</form>		
			</div>
			<div class="blankbox"></div>
			<div class="logbox">
				<h3>Sign In</h3>
				<p>Already have an account?
				<form class="loginform">
					<div>
						<label for="email"><b>Email</b></label>
						<input type="text" placeholder="Enter Email" />
					</div>
					<div>
						 <label for="psw"><b>Password</b></label>
						 <input type="password" placeholder="Password" />
					</div>
					<div>
						  <label for="confirmpass"><b>Confirm Password</b></label>
						  <input type="password" placeholder="Confirm Password" />
					</div>
					<button type="submit" class="registerbtn">Sign In</button>
				</form>
			</div>
		</div>
	</div>
	<footer class="foot-content">
		<div class="foot-box">
		<h3>California Office</h3>
			<div class="policyrow"><p>© 2022 GulSoft. All Rights Reserved. <a href="">Privacy Policy</a></p></div>
		</div>
	</footer>	
</div>
</body>
</html>