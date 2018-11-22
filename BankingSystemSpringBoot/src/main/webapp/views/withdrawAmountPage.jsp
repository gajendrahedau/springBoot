<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Amount</title>
<style>
input[type=text] {
	width: 100%;
	padding: 10px 15px;
	margin: 8px 0;
	box-sizing: border-box;
	border: medium;
	border-color: black;
	background-color: silver;
	color: black;
}

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
	<div style="top: 500; left: 480; position: absolute;">
		<form action="withdrawAmount" method="post">
			<div align="center">
				<table>
					<tr>
						<th><font size="6" face="Comic Sans MS,Lucida Console"
							color="brown">Withdraw Money :</font></th>
					</tr>
					<tr>
						<td><font size="4">Enter Amount:</font></td>
						<td><input type="number" name="amount" id="amount" required /></td>
					</tr>
					<tr>
						<td><font size="4">Enter pin number:</font></td>
						<td><input type="number" name="pinNumber" id="pinNumber"
							required></td>

					</tr>
					<tr align="center">
						<td align="right"><input type="submit" name="submit"
							id="submit"></td>
						<td><a href="loginSuccessPage"><input type="button"
								value="Back" name="back" id="back" /></a></td>

					</tr>
					<tr>
						<td><font color="green" size="5">${requestScope.amount}</font></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>