<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping_adminlogin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="home.css">
</head>

<body background="shopping_home.jpg">

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<div class="navbar-brand" href="#">Shopping center</div>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#myLogin" data-toggle="modal"
				data-target="#myLogin"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
	</nav>

	<form action="adminHomeInter.jsp" method="post">
		<!-- Modal -->
		<div class="modal fade" id="myLogin" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Admin Login</h4>
					</div>
					<div class="modal-body">
						<table>
							<tr>
								<td height="50" width="30%"><label>UserId:</label></td>
								<td height="50" width="70%"><input type="text"
									class="form-control" name="uid" id="uid" required></td>
							</tr>
							<tr>
								<td height="50" width="30%"><label>Password:</label></td>
								<td height="50" width="70%"><input type="text"
									class="form-control" name="psw" id="psw" required></td>
							</tr>
						</table>
						<div class="cls" style="align: center">
							<button type="submit" class="btn btn-primary" id="login">Login</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>
					</div>
					<center>
						<p style="color: red;">${errorMsg}</p>
					</center>
					<div class="modal-footer">
						<p>
							<span style="color: red">*</span>All fields are mandatory
						</p>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>