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
<!-- My JS -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/style.css"> 
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script type = "text/javascript" src='/js/scripts.js'></script>
	<meta charset="ISO-8859-1">
	<title>GulSoft</title>
</head>
<body>
<div class="bg-container">
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
	<div class="content">
		<div class="box">
			<div class="row1">
				<h3>ABOUT US</h3>
				<h1>Software and Architectural Development Counsultancy</h1>
				<p>Our software development company delivers corporate and consumer applications based on our profound understanding of technologies and the markets they operate in. With our professional mindset, we look beyond technology to offer viable solutions for your particular business context.
				</p>
			</div>
			<div class="row">
				<div class="img-box"><img src="images/pic2.jpg" alt="logo"></div>
				<div class="img-box"><img src="images/pic3.jpg" alt="logo"></div>
				<div class="img-box"><img src="images/pic2.jpg" alt="logo"></div>
			</div>
		</div>
	</div>
	<footer class="foot-content">
		<div class="foot-row">
			<h1>Let's work together.</h1>
			<p>We believe in strong partnerships,<br/> not just technology innovations.</p>
			<a href="https://login.codingdojo.com"><button class="talk-btn">LET'S TALK</button></a>
		</div>
		<div class="foot-box">
			<div class="footer-box">
			<img src="images/gulsoft.png" alt="logo">
				<div class="fb-row">
					<a href="#"><img src="images/fb.jpg" alt="facebook"></a>
					<a href="#"><img src="images/in.png" alt="facebook"></a>
					<a href="#"><img src="images/twt.jpg" alt="facebook"></a>
				</div>
			</div>
			<div class="footer-box">
				<h2>About</h2>
				<ul>
				  <li>History</li>
				  <li><a class="titles" href="">Careers</a></li>
				</ul>
			</div>
			<div class="footer-box">
				<h2>Resource</h2>
				<ul >
				  <li>Blog</li>
				  <li>Case Studies</li>
				  <li>Free Trainings</li>
				</ul>
			</div>
			<div class="footer-box">
				<h2>Our Services</h2>
				<ul>
				  <li>Software Engineering</li>
				  <li>Architectural Design</li>
				  <li>Service Design</li>
				  <li>Trainings</li>
				</ul>
			</div>
		</div>
		<div class="foot-box">
		<h3>California Office</h3>
			<div class="policyrow"><p>© 2022 GulSoft. All Rights Reserved. <a href="">Privacy Policy</a></p></div>
		</div>
	</footer>	
</div>
</body>
</html>