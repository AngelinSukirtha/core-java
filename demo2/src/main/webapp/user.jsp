<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.chainsys.demo2.model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
<style>
body {
	background-color: rgb(230, 230, 230);
}

.container {
	margin-top: 20px;
}

table {
	width: 100%;
	background-color: white;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	text-align: center;
	border: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

.btn {
	padding: 5px 10px;
	cursor: pointer;
}

.btn-edit {
	background-color: #4CAF50;
	color: white;
	border: none;
	text-decoration: none;
}

.btn-delete {
	background-color: #f44336;
	color: white;
	border: none;
}
</style>
</head>
<body>
	<%
	List<User> users = (List<User>) request.getAttribute("user_list");
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<table id="userTable"
					class="table table-bordered table-condensed table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Password</th>
							<th>Phone Number</th>
							<th>Email</th>
							<th colspan="2">Update</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (User user : users) {
						%>
						<tr>
							<td><%=user.getUserId()%></td>
							<td><%=user.getUserName()%></td>
							<td><%=user.getUserPassword()%></td>
							<td><%=user.getPhoneNumber()%></td>
							<td><%=user.getEmail()%></td>
							<td><a href="update.jsp" class="btn btn-edit">Edit</a></td>
							<td>
								<form action="/delete" method="get">
									<input type="hidden" name="userId"
										value="<%=user.getUserId()%>">
									<button type="submit" class="btn btn-delete">Delete</button>
								</form>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
