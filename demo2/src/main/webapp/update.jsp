<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update</title>
<style>
body {
	background-color: black;
	color: white;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	margin-top: 50px;
	margin: 0;
}

.container {
	max-width: 400px;
	margin: 50px auto;
	padding: 20px;
	background-color: rgb(32, 32, 32);
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

h2 {
	text-align: center;
	color: white;
}

label {
	display: block;
	margin-bottom: 10px;
	font-weight: bold;
	color: white;
}

input[type="text"], input[type="password"], input[type="email"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #444;
	border-radius: 5px;
	box-sizing: border-box;
	background-color: #333;
	color: white;
}

button[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

button[type="submit"]:hover {
	background-color: #0056b3;;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Update</h2>
		<form action="/update" method="post">
			User Name:<input type="text" id="userName" name="userName"
				pattern="[A-Z a-z]{5,}" required> Password: <input
				type="password" id="userPassword" name="userPassword"
				pattern="[A-z a-z 0-9]{8}" required> Phone Number: <input
				type="text" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10}"
				required> Email: <input type="email" id="email" name="email"
				pattern="[a-z0-9]+@[a-z0-9]+\.[a-z]{2,}$" required> <input
				type="hidden" name="action" value="register">
			<button type="submit">Update</button>
		</form>
	</div>
</body>
</html>
