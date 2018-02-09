<%@ page language="java" contentType="text/html; charset=UTF-8"
   2         pageEncoding="UTF-8"%>
   3 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   4 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   5 <html>
   6 <head>
   7 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   8 <title>Shoppiee</title>
   9 <script
  10         src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  11 <script
  12         src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  13 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  14 <link rel="stylesheet"
  15         href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  16 <link rel="stylesheet" href="shopping.css">
  17 <link rel="stylesheet" href="admin.css">
  18 <style>
  19 div.transbox {
  20         margin: 100px;
  21         background-color: #ffffff;
  22         border: 0px solid black;
  23         border-radius: 10px;
  24         padding: 50px 30px 50px 80px;
  25         opacity: 0.8;
  26         filter: alpha(opacity = 60); /* For IE8 and earlier */
  27 }
  28 </style>
  29 <title>Insert title here</title>
  30 </head>
  31 <body background="images/eshopping.jpg">
  32 
  33         <div class="container">
  34                 <div class="row" style="background-color: #3e3436">
  35                         <div class="col-md-1">
  36 
  37                                 <div class="menu-wrap">
  38                                         <nav class="menu">
  39                                         <div class="navbar-header">
  40                                                 <a class="navbar-brand" href="#">Shoppiee</a>
  41                                         </div>
  42                                         <ul class="nav navbar-nav">
  43                                                 <li><a href="#">Categories</a></li>
  44                                                 <li><a href="#">Users</a></li>
  45                                         </ul>
  46                                 </div>
  47                         </div>
  48                         <div class="col-md-1  col-md-offset-10">
  49                                 <ul class="nav navbar-nav navbar-right">
  50                                         <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>
  51                                                         Logout</a></li>
  52                                 </ul>
  53                         </div>
  54                 </div>
  55 
  56 
  57 
  58 
  59                 <div class="row">
  60 
  61 
  62 
  63 
  64                         <div class="col-md-6  col-md-offset-3">
  65 
  66                                 <form action="editcat.jsp" method="post">
  67                                         <button style="text-align: right;" onclick="goBack()">back</button>
  68                                         <div class="modal-dialog">
  69 
  70 
  71                                                 <div class="modal-content">
  72                                                         <c:forEach items="${catList}" var="cList">
  73                                                                 <div class="modal-header">
  74 
  75                                                                         <h2 class="modal-title">
  76                                                                                 category : <u><b>${cList.cat}</b></u>
  77                                                                         </h2>
  78                                                                 </div>
  79                                                                 <div class="modal-body">
  80                                                                         <p>Description :</p>
  81                                                                         <textarea rows="4" cols="50" readonly="readonly">${cList.des}</textarea>
  82 
  83 
  84 
  85 
  86                                                                 </div>
  87                                                         </c:forEach>
  88 
  89                                                         </br>
  90 
  91                                                         <div class="modal-footer">
  92                                                                 <center>
  93                                                                         <button type="button" class="btn" data-toggle="modal"
  94                                                                                 data-target="#Products">
  95                                                                                 <b>add products</b>
  96                                                                         </button>
  97                                                                 </center>
  98                                                         </div>
  99                                                 </div>
 100                                         </div>
 101                                 </form>
 102 
 103 
 104 
 105 
 106 
 107 
 108                                 <form action="addProducts.jsp" method="post">
 109                                         <!-- Modal -->
 110                                         <div class="modal fade" id="Products" role="dialog">
 111                                                 <div class="modal-dialog">
 112                                                         <!-- Modal content-->
 113                                                         <div class="modal-content">
 114                                                                 <div class="modal-header">
 115                                                                         <button type="button" class="close" data-dismiss="modal">&times;</button>
 116                                                                         <h4 class="modal-title">Add Product</h4>
 117                                                                 </div>
 118                                                                 <div class="modal-body">
 119                                                                         <input type="text" class="form-control" name="pname" id="pname"
 120                                                                                 placeholder="Product Name " required><br>
 121                                                                         <textarea class="form-control" rows="5" name="pdes" id="pdes"
 122                                                                                 placeholder="Product Description" required></textarea>
 123                                                                         <br> <input type="number" class="form-control" name="pno"
 124                                                                                 id="pno" placeholder="enter available count " required><br>
 125                                                                         <input type="number" class="form-control" name="price"
 126                                                                                 id="price" placeholder="enter price of product " required><br>
 127                                                                         <select name="pcat" id="pcat">
 128                                                                                 <c:forEach items="${catList}" var="cList">
 129                                                                                         <option><a data-toggle="modal"
 130                                                                                                         data-target="#Category" name="ctg" value="${cList.cat}">${cList.cat}</a></option>
 131                                                                                 </c:forEach>
 132                                                                         </select></br>
 133                                                                         </br>
 134                                                                         <button type="submit" class="btn btn-primary" id="login">Add
 135                                                                                 Products</button>
 136                                                                         <button type="reset" class="btn btn-danger"
 137                                                                                 data-dismiss="modal">Clear</button>
 138                                                                 </div>
 139                                                                 <div class="modal-footer"></div>
 140                                                         </div>
 141 
 142                                                 </div>
 143                                         </div>
 144                                 </form>
 145 
 146 
 147 
 148 
 149 
 150 
 151                                 <form action="editProducts.jsp" method="post">
 152 
 153 
 154                                         <div class="modal fade" id="editProducts" role="dialog">
 155                                                 <div class="modal-dialog">
 156 
 157                                                         <!-- Modal content-->
 158                                                         <div class="modal-content">
 159                                                                 <div class="modal-header">
 160                                                                         <button type="button" class="close" data-dismiss="modal">&times;</button>
 161                                                                         <h4 class="modal-title">editProduct</h4>
 162                                                                 </div>
 163 
 164 
 165                                                                 <div class="modal-body">
 166 
 167 
 168                                                                         <input type="text" class="form-control" name="pname" id="pname"
 169                                                                                 placeholder="Product Name " value="" required><br>
 170                                                                         <textarea class="form-control" rows="5" name="pdes" id="pdes"
 171                                                                                 placeholder="Product Description" required value=""></textarea>
 172                                                                         <br> <input type="number" class="form-control" name="pno"
 173                                                                                 id="pno" placeholder="enter available count " required
 174                                                                                 value=""><br> <input type="number"
 175                                                                                 class="form-control" name="price" id="price"
 176                                                                                 placeholder="enter price of product " required value=" "><br>
 177                                                                         <select name="pcat" id="pcat">
 178 
 179                                                                                 <a data-toggle="modal" data-target="#Category" name="ctg"
 180                                                                                 value=""></a>
 181                                                                         </option>
 182 
 183                                                                         </select></br>
 184                                                                         </br>
 185                                                                         <button type="submit" class="btn btn-primary" id="login">Add
 186                                                                                 Products</button>
 187                                                                         <button type="button" class="btn btn-danger"
 188                                                                                 data-dismiss="modal">Clear</button>
 189                                                                 </div>
 190                                                                 <div class="modal-footer"></div>
 191                                                         </div>
 192 
 193                                                 </div>
 194                                         </div>
 195 
 196                                 </form>
 197 
 198 
 199 
 200 
 201 
 202 
 203 
 204 
 205 
 206 
 207 
 208 
 209                         </div>
 210                 </div>
 211                 <div class="row">
 212                         <div class="transbox">
 213                                 <table width="100%" border="1">
 214                                         <tr>
 215                                                 <th width="30%">Product Name</th>
 216                                                 <th width="40%">Product Description</th>
 217                                                 <th width="10%">Products Available</th>
 218                                                 <th width="10%">Price</th>
 219                                                 <th width="10%">edit</th>
 220                                                 <th width="10%">Delete</th>
 221                                         </tr>
 222                                         <c:forEach items="${productList}" var="pList">
 223                                                 <tr>
 224                                                         <td>${pList.pname}</td>
 225                                                         <td>${pList.pdes}</td>
 226                                                         <td>${pList.pno}</td>
 227                                                         <td>${pList.price}</td>
 228                                                         <td><a href="editProduct.Ado?prodval=${pList.pname}"><span
 229                                                                         class="glyphicon glyphicon-pencil"></span></td>
 230                                                         <td><a href="deleteProduct.Ado?catval=${pList.pname}"><span class="glyphicon glyphicon-trash"></span></td>
 231                                                 </tr>
 232                                         </c:forEach>
 233                                 </table>
 234                         </div>
 235 
 236 
 237                 </div>
 238         </div>
 239         </div>
 240 </body>
 241 <body>
 242         <div class="footer">
 243                 <div row="" style="background-color: #3e3436;">
 244                         <div class="col-md-4" style="background-color: #3e3436;">
 245                                 <h4 style="color: silver;" align="center">copyright@shoppiee@narasimha.com</h4>
 246                                 <h4 style="color: silver;" align="center">Spaneos Softwares
 247                                         Solution Pvt.Ltd</h4>
 248                         </div>
 249 
 250                         <div class="col-md-4" style="background-color: #3e3436;">
 251                                 <h4 style="color: silver;" align="center">ph:7406701958</h4>
 252                                 <h4 style="color: silver;" align="center">email:
 253                                         in.narasimha.kk@spaneos.com</h4>
 254                         </div>
 255                 </div>
 256                 <div class="col-md-4" style="background-color: #3e3436;">
 257                         <h4 style="color: silver;"></h4>
 258                         <h4 style="color: silver;"></h4>
 259                 </div>
 260         </div>
 261         </div>
 262 
 263 </body>
 264 </html>