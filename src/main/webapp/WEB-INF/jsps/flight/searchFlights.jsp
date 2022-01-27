<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
	<h2>Flights</h2>
	<form action="showFlights" method="get">
		<table>
			<tr>
				<td>From</td>
				<td><input type="text" name="from" required></td>
			</tr>
			<tr>
				<td>To</td>
				<td><input type="text" name="to" required></td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><input type="text" name="departureDate" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
</body>
</html>