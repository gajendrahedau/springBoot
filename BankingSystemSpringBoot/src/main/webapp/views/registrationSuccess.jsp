<%@page import="com.cg.banking.beans.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<div align="center">
	
	<table>
	
	<tr><th>
	 Welcome </th></tr>
	 <tr><td>Your Account Details :<td></tr>
	<tr><td> Account number:</td><td>${account.accountNo} </td></tr>
	<tr><td> Account Type:</td><td>${account.accountType}</td></tr>
	 <tr><td>Pin Number:</td><td>${account.pinNumber}</td></tr>
	
	 </table>
	
	</div>
</body>
</html>