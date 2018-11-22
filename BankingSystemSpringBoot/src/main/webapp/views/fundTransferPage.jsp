<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
<style>
input[type=number] {
	width: 100%;
	padding: 10px 15px;
	margin: 8px 0;
	box-sizing: border-box;
	border: medium;
	border-color: black;
	background-color: silver;
	color: black;
}
input[type=submit] {
	font-size: 20px;
}
input[type=button] {
	font-size: 20px;
}
</style>
</head>
<body>
	<div style="top: 400; left: 300; position: absolute;">
	
	</div>
	<div style="top: 500; left: 480; position: absolute;">
		<form:form action="fundTransfer" method="post" modelAttribute="account">
			<div align="center">
				<table>
				<tr><th>	<font size="6" face="Comic Sans MS,Lucida Console" color="brown">Transfer
			Money :</font></th>
				</tr>
					<tr>
						<td><font size="4">Enter Receiver's Account Number:</font></td>
						<td><form:input path="accountNo" id="accountNo"/></td>
					</tr>
					<tr>
						<td><font size="4">Enter Amount:</font></td>
						<td><form:input path="accountBalance" id="accountBalance"/></td>
					</tr>
					<tr>
						<td><font size="4">Enter pin number:</font></td>
						<td><form:input path="pinNumber" id="pinNumber"/></td>
					</tr>
					<tr align="center">
						<td align="right"><input type="submit" name="submit" id="submit"></td>
						<td><a href="loginSuccessPage"><input type="button"
								value="Back" id="button"/></a></td>
					
					</tr>
					<tr>
				<td><font color="green" size="5">${requestScope.message}</font></td>

			</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>