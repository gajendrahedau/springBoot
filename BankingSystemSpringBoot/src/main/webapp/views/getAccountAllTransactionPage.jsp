<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Details</title>
<style>
input[type=submit] {
	font-size: 20px;
}
input[type=button] {
	font-size: 20px;
}
</style>
</head>
<body >
	<div style="top: 400; left: 520; position: absolute;">
		<form action="" method="post">
			<div align="center">
				<table>
					
				</table>
			</div>
		</form>
	</div>
	<div style="top: 500; left: 450; position: absolute;">
		<table border="1">
		<tr>
						<th align="right"><a href="loginSuccessPage"><input
								type="button"  id="button" value="Back" /></a></th>
					</tr>
			<tr>
				<th>TransactionId</th>
				<th>Transaction Amount</th>
				<th>Transaction Type</th>
			</tr>
			<c:forEach var="transaction"
				items="${requestScope.transactions}">
				<tr>
					<td>${transaction.transactionId}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.transactionType}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>