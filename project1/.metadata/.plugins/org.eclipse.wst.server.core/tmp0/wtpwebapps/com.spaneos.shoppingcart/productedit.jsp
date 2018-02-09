<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="shopping.css">
<link rel="stylesheet" href="home.css">

<title>Insert title here</title>
</head>
<body background="shopping_home.jpg">

	<div class="container">
		<div class="row" style="background-color: #3e3436">
			<div class="col-md-1">

				<div class="menu-wrap">
					<nav class="menu">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Shopping</a>
					</div>
					<ul class="nav navbar-nav">
						<li><a href="#">Categories</a></li>
						<li><a href="#">Users</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-1  col-md-offset-10">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>
							Logout</a></li>
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6  col-md-offset-3">

				<form action="editproducts.jsp" method="post">
					<button style="text-align: right;" onclick="goBack()">back</button>
					<div class="modal-dialog">


						<div class="modal-content">

							<div class="modal-header">
								<h4 class="modal-title">Edit products</h4>
							</div>
							<div class="modal-body">
								<c:forEach items="${productList}" var="pList">
									<h3>${pList.cat}</h3>
									<label>product Name <input type="text"
										value="${pList.pname}" name="pname" id="pname" readonly></label>
									</br>
									</br>
									<label>product category: <input type="text"
										value="${pList.pcat}" name="pcat" id="pcat" readonly></label>
									</br>
									<label>pdes: <input height="50" type="text"
										name="des" id="des" value="${pList.pdes}"></label>
									</br>
									</br>
									<label>pno: <input height="50" type="text"
										name="des" id="des" value="${pList.pno}"></label>
									</br>
									<label>price: <input height="50" type="text"
										name="des" id="des" value="${pList.price}"></label>
									</br>
									</br>
									<button type="submit" class="btn btn-primary" id="login">Edit
										Products</button>
									<button type="reset" class="btn btn-danger">Clear</button>
								</c:forEach>
							</div>
							<div class="modal-footer">
								<p>*All fields are mandatory</p>
							</div>
						</div>
					</div>
				</form>


			</div>
</body>
</html>