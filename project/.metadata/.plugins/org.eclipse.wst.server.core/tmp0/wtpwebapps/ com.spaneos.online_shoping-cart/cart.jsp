<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
            pageEncoding="ISO-8859-1" import="online_shopping.CategoryBean" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en">
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
            href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
   
   <link rel="stylesheet"
           href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet"
           href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   
   <script
           src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script
           src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script
           src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
   <head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Cart</title>
   <link rel="stylesheet" href="home.css">
   <script type="text/javascript">
           function disableF5(e) {
                   if ((e.which || e.keyCode) == 116 || (e.which || e.keyCode) == 82)
                           e.preventDefault();
           };
   
           $(document).ready(function() {
                   $(document).on("keydown", disableF5);
           });
   </script>
   </head>
   <body background="shopping_home.jpg">
           <!--Navigation bar -->
           <nav class="navbar navbar-inverse" style="background-color: #4457FA;">
           <div class="container-fluid">
   
                   <div class="row" style="background-color: #4457FA;">
                           <div class="col-md-4">
                                   <h1 style="color: white; font-family: fantasy; font-weight: 800;">
                                           <b>Shoppiee</b>
                                   </h1>
                           </div>
                           <div class="col-md-1 col-md-offset-5">
                                   <h5>
                                           <a href="userpage.jsp" style="color: white;">home</a>
                                   </h5>
                           </div>
                           <div class="col-md-1 ">
                                   <h5 style="color: black;">
                                           <a href="userpage.jsp" style="color: white;">Welcome : ${user}</a>
                                   </h5>
                           </div>
   
                           <div class="col-md-1">
                                   <h5>
                                           <a href="logout.Udo" style="color: black;">Logout</a>
                                   </h5>
                           </div>
   
                   </div>
           </nav>
           <b style="color: red;">${errorMsg}</b>
           <b style="color: red;">${message}</b>
           <!-- Displaying Cart Details -->
           <div id="container" style="margin-left: 10%; margin-right: 10%;">
                   <h3 align="center">
                           <u><b>Cart Details</b></u>
                   </h3>
                   <form action="viewcart.Udo" method="post">
                           <table class="table table-bordered" bgcolor="#00FF00">
                                   <thead>
                                           <tr>
                                                   <th></th>
                                                   <th>Products</th>
                                                   <th>Price</th>
                                                   <th>No. Of Units</th>
                                                   <th></th>
   
                                           </tr>
                                   </thead>
                                   <tbody>
                                           <c:forEach items="${cartList}" var="name">
                                                   <tr>
                                                           <td><input type="checkbox" name="names"
                                                                   value="${name.pname}" /></td>
                                                           <td>${name.pname}</td>
                                                           <td>${name.price}</td>
                                                           <td>${name.items}</td>
                                                           <td>${name.status}</td>
                                                           <td><a href="DelCartItem.Udo?names=${name.pname} "> <span
                                                                           class="glyphicon glyphicon-trash"></span></a></td>
   
  
                                                  </tr>
                                          </c:forEach>
  
                                  </tbody>
                          </table>
                          <!-- Button to CheckOut-->
 
                          <button type="button" class="btn btn-primary" style="float: right;"
                                  data-toggle="modal" data-target="#myModal">Chek Out</button>
                  </form>
                
                  <!-- Button to go to main page-->
                  <a href="goUser.Udo"><button type="submit" id="opener"
                                  class="btn btn-primary" style="float: left;">Browse More
                                 Items</button></a>
          </div>
          
          
          <!-- Modal -->
          
                 <div id="myModal" class="modal fade" role="dialog">
                          <div class="modal-dialog">
  
  
                                  <form action="checkout.Udo">
                                         <!-- Modal content-->
                                          <div class="modal-content">
                                                  <div class="modal-header">
                                                          <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                          <h4 class="modal-title" align="center">Total Amount to Pay</h4>
                                                  </div>
                                                  <div class="modal-body">
                                                          <p align="center" style="color: red;">
                                                                  <b>&#x20b9; </b>${totalamount}</p>
                                                  </div>
                                                  <div class="modal-footer">
                                                          <input type="submit" class="btn btn-success" value="Pay" />
                                                          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                                  </div>
                                         </div>
  
                                  </form>
  
                          </div>
                  </div>
          
  
 </body>
  </html>