<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css">
<style>
input.transparent-input {
	background-color: transparent !important;
	border: none !important;
}
</style>
<script type="text/javascript">
	$("#myElem1").show();
	setTimeout(function() {
		$("#myElem1").hide();
	}, 3000);
	$("#myElem2").show();
	setTimeout(function() {
		$("#myElem2").hide();
	}, 3000);
</script>
</head>
<body background="shopping_home.jpg">
	<div class="container-fluid">
		<div class="row" style="background-color: #4457FA;">
			<div class="col-md-4">
				<h1 style="color: black; font-family: fantasy; font-weight: 800;">
					<b style="color: white">Shopping <img src="shopping_home.jpg"
						height="50" width="50"></b>
				</h1>
			</div>
			<div class="col-md-2 col-md-offset-4">
				<h5 style="color: white;">Welcome : ${userr}</h5>
			</div>
			<div class="col-md-1 ">
				<h5 style="color: black;">
                                           <a href="goUser.Udo" style="color: white;">Home</a>
                                   </h5>
			</div>
			<div class="col-md-1">
				<h5 style="color: black;">
					<a href="cart.Udo?username=${userr}" style="color: white;"><span
						class="glyphicon glyphicon-shopping-cart"></span></a>
				</h5>
			</div>
			<div class="col-md-1">
				<h5>
					<a href="logout.Udo" style="color: white;">Logout</a>
				</h5>
			</div>

		</div>
		<div class="row">
			<ul></ul>
			<div class="col-md-2" style="background-color: #4457FA;">
				<h1 style="color: black;">
					<u><b style="color: black">Categories</b></u>
				</h1>
				<c:forEach items="${catList}" var="cList">
					<li style="list-style-type: none;"><a
						href="cat.Udo?cat=${cList.cat}"
						style="color: black; font-size: medium;"><b
							style="color: black">${cList.cat}</b></a></br></li>
				</c:forEach>
			</div>
			</ul>
			<div class="col-md-8">
				<!--Navigation bar -->
				<nav class="navbar navbar-inverse"
					style="background-color: #4457FA;">
				<div class="container-fluid">
					<div class="navbar-header">
						<a style="font-size: x-large; color: black;">${catName}</a>
					</div>


				</div>
				</nav>
				<!-- Heading -->
				<div id="container" style="margin-left: 10%; margin-right: 10%;">


					<h2>Product Details</h2>

					<table class="table table-bordered">
						<thead>
							<tr>

								<th>Products</th>
								<th>Price</th>
								<th>In Stock</th>
								<th>Items</th>
								<th>Add to Cart</th>

							</tr>
						</thead>
						<tbody>
							<p id=myElem1 style="color: red">${errorMsg}</p>
							<p id=myElem2 style="color: red">${successMsg}</p>
							<c:forEach items="${productList}" var="name">
								<tr>
									<form action="addtocart.Udo" method="post">
										<div>
											<input style="border: 0px; background: transparent;"
												class="transparent-input" type="hidden" name="pcat"
												readonly="readonly" value="${name.pcat}" />
											<td><b> <input class="transparent-input" type="text"
													name="pname" readonly="readonly" value="${name.pname}" /></b></td>
											<td><b> <input class="transparent-input"
													type="number" name="price" readonly="readonly"
													value="${name.price}" /></b></td>
											<td><b> <input class="transparent-input"
													type="number" name="stock" readonly="readonly"
													value="${name.pno}" /></b></td>
											<td><input type="number" class="form-control"
												name="item" id="item" required="required" min="1"
												max="${name.pno}"></td>
											<td><button type="submit" id="opener"
													class="btn btn-primary" style="float: right;">Add
													to Cart</button> <br></td>
									</form>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					<!-- Button to pop up form -->

				</div>
			</div>
		</div>

	</div>

</body>
</html>