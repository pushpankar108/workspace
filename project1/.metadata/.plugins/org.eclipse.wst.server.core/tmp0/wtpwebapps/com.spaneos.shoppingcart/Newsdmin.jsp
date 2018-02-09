<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping _admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="home.css">
<link rel="stylesheet" href="home.css">
<style>
div.transbox {
	margin: 100px;
	background-color: #c9d1d8;
	border: 0px solid black;
	border-radius: 10px;
	padding: 50px 30px 50px 80px;
	opacity: 0.9;
	filter: alpha(opacity = 60); /* For IE8 and earlier */
}

th {
	width: 30%;
	height: 10%;
}
</style>
</head>

<body background="shopping_home.jpg">
<div class="container">
		<div class="row" style="background-color: #3e3436">
			<div class="col-md-2">
				<div class="menu-wrap">
					<nav class="menu">
					<div class="navbar-header">
						<span class="glyphicon glyphicon-shopping-cart"></span>
						</p>
						<a href="admin_page.jsp">&nbsp&nbsp&nbsp Admin Home <span
							class="glyphicon glyphicon-shopping-cart"></span>
						</a>
					</div>
					
					<ul class="nav navbar-nav">
						<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories <span
								class="caret"></span></a>
							<ul class="dropdown-menu" name="catg">

								<c:forEach items="${catList}" var="cList">
									<th><a href="edit.Ado?catval=${cList.cat}"
										value="${cList.cat}">${cList.cat}</a>&nbsp&nbsp&nbsp</th>
									<td><a href="delete.Ado?catval=${cList.cat}"><span
											class="glyphicon glyphicon-trash"></span></a>&nbsp&nbsp&nbsp </td><td><a
											href="edit.Ado?catval=${cList.cat}"><span
											class="glyphicon glyphicon-pencil"></span></a>&nbsp&nbsp&nbsp</td><td>
											<button data-toggle="modal" data-target="#Products"><span
											class="glyphicon glyphicon-th-list"></span></button></td>
									
									<br>
								</c:forEach>
								<li><button type="button" class="btn" data-toggle="modal"
										data-target="#myCategory">
										<b>Add New Category</b>
									</button>
									</li>
							</ul></li>
						<li><a href="#">Users</a></li>
					</ul>
				</div>
			</div>

			<div class="col-md-2  col-md-offset-6">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>
							Logout</a></li>
				</ul>
			</div>
		</div>
		
		
		
		
		
		
		<!-- adding new category -->

			<form action="adminPageInter.jsp" method="post">
				Modal
				<div class="modal fade" id="myCategory" role="dialog">
					<div class="modal-dialog">
						Modal content
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add new category</h4>
							</div>
							<div class="modal-body">
								<input type="text" class="form-control" name="newcat"
									id="newcat" placeholder="Add Category Name" required><br>
								<textarea class="form-control" rows="5" name="newdes"
									id="newdes" placeholder="Enter description" required></textarea>
								<br>
								<button type="submit" class="btn btn-primary" id="login">Add
									Category</button>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Clear</button>
							</div>
							<div class="modal-footer">
								<p>*All fields are mandatory</p>
							</div>
						</div>

					</div>
				</div>
			</form>
			
			
			
			
			
			
			
			
			<!-- popup to display selected category -->


			<form action="adminPageInter.jsp" method="post" >
				<!-- Modal -->
				<div class="modal fade" id="myCategory" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								
								<h4 class="modal-title">Edit Category</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">

								<button type="submit" class="btn btn-primary" id="login">Add 
									Products</button>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Clear</button>
							</div>
							<div class="modal-footer">
								<ul class="dropdown-menu">
									<c:forEach items="${productList}" var="pList">
										<li name="ctg" id="ctg"><a data-toggle="modal"
											data-target="#Category">${pList.pname}</a></li>
									</c:forEach>
									<li><button type="button" class="btn" data-toggle="modal"
											data-target="#Products1">
											<b>update category</b>
										</button></li>
								</ul>
							</div>
							<button type="button" class="btn" data-toggle="modal"
								data-target="#Products1">
								<b>updates products</b>
							</button>
						</div>

					</div>
				</div>
			</form>
			 
			 
			 
			 
			 
			 <!-- adding products to categories -->

			 <form action="addProducts.jsp" method="post">
				<!-- Modal -->
				<div class="modal fade" id="Products" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add Product</h4>
							</div>
							<div class="modal-body">
								<input type="text" class="form-control" name="pname" id="pname"
									placeholder="Product Name " required><br>
								<textarea class="form-control" rows="5" name="pdes" id="pdes"
									placeholder="Product Description" required></textarea>
								<br> <input type="number" class="form-control" name="pno"
									id="pno" placeholder="enter available count " required><br>
								<input type="number" class="form-control" name="price"
									id="price" placeholder="enter price" required><br>
								<select name="pcat" id="pcat">
									 <c:forEach items="${catList}" var="cList">
										<option>
										<a data-toggle="modal" data-target="#Category" name="ctg" value="${cList.cat}">${cList.cat}</a></option>
									 </c:forEach> 
								</select></br> </br>
								<button type="submit" class="btn btn-primary" id="login">Add
									Products</button>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Clear</button>
							</div>
							<div class="modal-footer"></div>
						</div>

					</div>
				</div>
			 </form> 
			 
			 
			 
			 
			 
			 
			<!--  edit products -->
			
			
			
			
			
			
		<div class="modal fade" id="Products1" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->

			<div class="modal-content">

				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal">&times;</button>

					<h4 class="modal-title">Add Product</h4>

				</div>
				
				<form  method="post">

					<div class="modal-body">
						<input type="text" class="form-control" name="pname" id="pname"
							placeholder="Product Name " required><br>
						<textarea class="form-control" rows="5" name="pdes" id="pdes"
							placeholder="Product Description" required></textarea>
						<br> <input type="number" class="form-control" name="pno"
							id="pno" placeholder="enter available count " required><br>
						<input type="number" class="form-control" name="price" id="price"
							placeholder="enter price of product " required><br>
						<select name="pcat" id="pcat">
							<c:forEach items="${catList}" var="cList">
								<option><a data-toggle="modal" data-target="#Category"
										name="ctg" value="${cList.cat}">${cList.cat}</a></option>
							</c:forEach>

						</select></br> </br>
						<button type="submit" class="btn btn-primary" id="login">Add
							Products</button>

						<button type="reset" class="btn btn-danger" data-dismiss="modal">Clear</button>

					</div>
			</form>
					

					<div class="modal-footer"></div>
			</div>

		</div>

	</div>
	
	
	
	
	