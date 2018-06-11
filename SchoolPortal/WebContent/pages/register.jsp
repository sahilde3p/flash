<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.sahil.Handler"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register at Lambton College</title>
</head>
<body>
	<form action="registrationverification" method="post">
		<table>
			<tr>

				<td>First Name:</td>
				<td><input type="text" name="firstname" /></td>
			<tr />

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastname" /></td>
			<tr />



			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" /></td>
			<tr />

			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="password" /></td>
			<tr />



			<tr>
				<td>Course List:</td>
				<td><select name="cars" multiple>

						<%
							for (String l : Handler.listFile()) {
						%>
						<option value="volvo"><%=l%></option>
						<%
							}
						%>

				</select></td>
			</tr>

			<tr>

				<td><input type="submit" value="Login" /></td>

			</tr>


		</table>
		${userid}
	</form>
</body>
</html>