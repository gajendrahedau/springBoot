

<%@page import="com.cg.banking.beans.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
<style>
input[type=submit] {
	font-size: 20px;
}
input[type=button] {
	font-size: 20px;
}
.t1 {
	font-size: 20px;
	text-color: green;
}
</style>
</head>
<body >
	

	<div style="top: 400; left: 560; position: absolute;">
		<table class="t1">
			<tr>
				<td>Account Type:</td>
				<td>${requestScope.account.accountType}</td>
			</tr>
			<tr>
				<td>Account Balance:</td>
				<td>${requestScope.account.accountBalance}</td>
			</tr>
			<tr>
				<td>Account Number:</td>
				<td>${requestScope.account.accountNo}</td>
			</tr>
			<tr>
				<td>Pin Number:</td>
				<td>${requestScope.account.pinNumber}</td>
			</tr>
			<tr>
				<td>Account Status:</td>
				<td>${requestScope.account.status}</td>
			</tr>
			<tr align="center">
				<td><a href="loginSuccessPage"><input type="button"
						value="Back" id="button" /></a></td>
				
			</tr>
		</table>
	</div>
</body>
</html>