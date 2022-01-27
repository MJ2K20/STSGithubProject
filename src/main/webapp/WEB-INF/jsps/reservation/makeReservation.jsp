<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body>
	<h4>Flight Number: ${flight.flightNumber}</h4>
	<h4>Operating Airline: ${flight.operatingAirlines}</h4>
	<h4>Departure City: ${flight.departureCity}</h4>
	<h4>Arrival City: ${flight.arrivalCity}</h4>
	<h4>Departure Date: ${flight.estimatedDepartureTime}</h4>

	<form action="completeReservation" method="post">
		<table>
			<tr>
				<td>Enter Passenger Details</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" required></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type="text" name="middleName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" required></td>
			</tr>
			<tr>
				<td>Enter Card details:</td>
			</tr>
			<tr>
				<td>Card Holder Name</td>
				<td><input type="text" name="cardHolderName" required></td>
			</tr>
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNumber" required></td>
			</tr>
			<tr>
				<td>Expiry</td>
				<td><input type="text" name="expiry" required></td>
			</tr>

			<input type="hidden" name="flightId" value="${flight.id}">

			<tr>
				<td><input type="submit" value="Complete Reservation"></td>
			</tr>
		</table>
	</form>

</body>
</html>