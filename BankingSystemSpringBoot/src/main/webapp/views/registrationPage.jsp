<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="registerAccount" method="post">
			<table>
				<tr>
					<td>Account Type:</td>
					<td><input list="accountType" name="accountType"  id="accountType">
  <datalist id="accountType">
    <option value="savings">
    <option value="current">
   </datalist></td>

				</tr>

				<tr>
					<td>accountBalance:</td>
					<td><input type="number"  min="500" name="accountBalance" id="accountBalance" size="30" required="required"/></td>

				</tr>
				<tr>
					<td>PIN number:</td>
					<td><input type="number" name="pinNumber" min="1000" max="9999" id="pinNumber" size="30" required="required"/></td>

				</tr>
				<tr>
					<td><input type="submit" value="submit" id="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>