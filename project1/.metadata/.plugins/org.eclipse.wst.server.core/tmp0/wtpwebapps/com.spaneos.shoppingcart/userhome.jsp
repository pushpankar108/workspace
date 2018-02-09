<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User home</title>
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
			<a class="navbar-brand" href="#">Shopping center</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#mySignUp" data-toggle="modal"
				data-target="#mySignUp"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="#myLogin" data-toggle="modal"
				data-target="#myLogin"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
	</nav>

	<form action="userhomeInter.jsp" method="post">
		<!-- Modal for user login-->
		<div class="modal fade" id="myLogin" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">User Login</h4>
					</div>
					<div class="modal-body">
						<table  >
							<tr>
								<td height="50" width="30%"><label>UserId:</label></td>
								<td height="50" width="70%"><input type="text"
									class="form-control" name="uid" id="uid" required></td>
							</tr>
							<tr>
								<td height="50" width="30%"><label>Password:</label></td>
								<td height="50" width="70%"><input type="text" type="password" 
									class="form-control" name="psw" id="psw" required></td>
							</tr>
						</table>
						<button type="submit" class="btn btn-primary" id="login">Login</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						
					</div>
					<center>
						<p style="color: red;"><%-- ${errorMsg} --%> </p>
					</center>
					<div class="modal-footer">
						<p>*All fields are mandatory</p>
					</div>
				</div>
			</div>
			</form>
		</div>
		
		<!-- Modal for sign-up-->
		<div class="modal fade" id="mySignUp" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">New User Registration</h4>
					</div>
					        <form action="registerInter.jsp" method="get">
					<div class="modal-body">
							User Name:<input type="text" class="form-control" name="name" id="name"
							placeholder="Enter your name" required><br> 
							Email:<input type="text" class="form-control" type="email" name="email" id="email"
							placeholder="Enter your email id" required><br>
							Password:<input type="text" class="form-control" type="password"  name="pass" id="pass"
							placeholder="Enter password" required><br>
							Confirm-Pwd:<input type="text" class="form-control" type="password"  name="rpass" id="rpass"
							placeholder="Confirm password" required><br>
							Mob number:<input type="text" class="form-control" name="mobile" id="mobile"
							placeholder="Enter your mobile no." required><br>
							Dob:<input type="date" class="form-control" name="date" id="date"
							placeholder="mm/dd/yyyy" required><br> <input
							type="radio" name="optradio"  value="male" checked></br>
							Male: <input type="radio"name="optradio"  value="female">Female: <br>
							<textarea class="form-control"name="address" rows="5" id="comment"
							placeholder="Billing Address" required></textarea>
							<br> <input type="checkbox" value="" required> I agree to all
							the terms and conditions.<br> <br>
							<button type="submit" class="btn btn-primary" id="reg">Register</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">Clear</button>
					</div>
						</form>
					
					<center>
						<p style="color: red;">${errorMsg}</p>
					</center>
					<div class="modal-footer">
						<p>*All fields are mandatory</p>
					</div>
					
				</div>
			</div>
		</div>
</body>
</html>
