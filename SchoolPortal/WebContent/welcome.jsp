<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sahil.UserInfo"%>




<!DOCTYPE html>
<html>
<%
	response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
	if (session.getAttribute("login") == null) {
		response.sendRedirect("index.jsp");
	}
%>
<%
	
%>
<head>
<title>Welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif
}
</style>
</head>
<body class="w3-light-grey">

	<!-- Page Container -->
	<div class="w3-content w3-margin-top" style="max-width: 1400px;">

		<!-- The Grid -->
		<div class="w3-row-padding">

			<!-- Left Column -->
			<div class="w3-third">

				<div class="w3-white w3-text-grey w3-card-4">
					<div class="w3-display-container">
						<img src="http://www.fmclinic.co.uk/assets/unknown_user_large.png"
							style="width: 100%" alt="Avatar">
						<div class="w3-display-bottomleft w3-container w3-text-black">

							<h2>${login.getFirstName()}${login.getLastName()}</h2>
						</div>
					</div>
					<div class="w3-container">
						<p>
							<i
								class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i>${login.getCourse()}</p>

						<p>
							<i
								class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>${login.getEmail()}</p>

						<hr>

						<p class="w3-large">
							<b><i
								class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i><a
								href="signout">Signout</a></b>
						</p>
						<p>Success Rate of Lambton College</p>
						<div class="w3-light-grey w3-round-xlarge w3-small">
							<div class="w3-container w3-center w3-round-xlarge w3-teal"
								style="width: 90%">90%</div>
						</div>
						<p>International Students Recommendation</p>
						<div class="w3-light-grey w3-round-xlarge w3-small">
							<div class="w3-container w3-center w3-round-xlarge w3-teal"
								style="width: 96%">
								<div class="w3-center w3-text-white">96%</div>
							</div>
						</div>
						<p>Illustrator</p>
						<div class="w3-light-grey w3-round-xlarge w3-small">
							<div class="w3-container w3-center w3-round-xlarge w3-teal"
								style="width: 75%">75%</div>
						</div>
						<p>Media</p>
						<div class="w3-light-grey w3-round-xlarge w3-small">
							<div class="w3-container w3-center w3-round-xlarge w3-teal"
								style="width: 50%">50%</div>
						</div>
						<br> <br>
					</div>
				</div>
				<br>

				<!-- End Left Column -->
			</div>

			<!-- Right Column -->
			<div class="w3-twothird">

				<div class="w3-container w3-card w3-white w3-margin-bottom">
					<h2 class="w3-text-grey w3-padding-16">
						<i
							class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Lambton
						College
					</h2>
					<div class="w3-container">
						<h5 class="w3-opacity">
							<b>Our Board</b>
						</h5>
						<h6 class="w3-text-teal">
							<i class="fa fa-calendar fa-fw w3-margin-right"></i>Jan 2015 - <span
								class="w3-tag w3-teal w3-round">Current</span>
						</h6>
						<p>Lambton College is a community college whose staff,
							faculty, and administrators provide quality post-secondary
							education in Southwestern Ontario. Our mission is commitment to
							student and community success. Nationally renowned for its
							ability to align programs with the needs of industry, Lambton
							Collge currently boasts the highest employer satisfaction rate in
							Ontario, according to the latest Key Performance Indicator (KPI)
							report and ranks third in Canada for Applied Research. These
							rankings reinforce what the College has worked hard to achieve: a
							supportive and innovative campus environment that bridges the gap
							between education and industry.</p>
						<hr>
					</div>
					<div class="w3-container">
						<h5 class="w3-opacity">
							<b>Campus Map</b>
						</h5>

						
						<h3>
							<a
								href="https://www.lambtoncollege.ca/Contact/Locations/Main_Campus/">Main
								Campus - Sarnia</a>
						</h3>
						
						<h3>
							<a
								href="https://www.lambtoncollege.ca/Contact/Locations/Lambton_in_Mississauga/">Lambton
								in Mississauga</a>
						</h3>
						
						<h3>
							<a
								href="https://www.lambtoncollege.ca/Contact/Locations/Lambton_in_Toronto/">Lambton
								in Toronto</a>
						</h3>
						
						<hr>
					</div>
					<div class="w3-container">
						<h5 class="w3-opacity">
							<b>Copyrights &copy; Lambton College Sarnia</b>
						</h5>
						<h6 class="w3-text-teal">
							<i class="fa fa-calendar fa-fw w3-margin-right"></i>Present
						</h6>
						<p>
							<a href="https://lambtoncollege.ca">https://lambtoncollege.ca</a>
						</p>
						<br>
					</div>
				</div>

				<div class="w3-container w3-card w3-white">
					<h2 class="w3-text-grey w3-padding-16">
						<i
							class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Education
					</h2>
					<div class="w3-container">
						<h5 class="w3-opacity">
							<b>Moodle</b>
						</h5>
						<h6 class="w3-text-teal">
							<i class="fa fa-calendar fa-fw w3-margin-right"></i>Forever
						</h6>
						<p>
							All I need to know in one place and make it simpler online by <a
								href="https://moodle.queenscollege.ca">Moodle</a>
						</p>
						<hr>
					</div>
					<div class="w3-container">
						<h5 class="w3-opacity">
							<b>Queens COllege</b>
						</h5>
						<h6 class="w3-text-teal">
							<i class="fa fa-calendar fa-fw w3-margin-right"></i>2016
						</h6>
						<p>Private career college</p>
						<hr>
					</div>

				</div>
			</div>

			<!-- End Right Column -->
		</div>

		<!-- End Grid -->
	</div>

	<!-- End Page Container -->


	<footer class="w3-container w3-teal w3-center w3-margin-top">
		<p>Find me on social media.</p>
		<a href="https://www.facebook.com/sahild33p" target="_blank"> <i
			class="fa fa-facebook-official w3-hover-opacity"></i></a> <a
			href="https://www.instagram.com/sahilde3p/" target="_blank"> <i
			class="fa fa-instagram w3-hover-opacity"></i></a> <a
			href="https://www.linkedin.com/in/sahildeep/" target="_blank"> <i
			class="fa fa-linkedin w3-hover-opacity"></i></a>
		<p>
			&copy; <a href="#" target="_blank">Sahildeep Singh</a>
		</p>
	</footer>

</body>
</html>

