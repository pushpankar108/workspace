<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String catg=request.getParameter("newcat");  
String desc=request.getParameter("newdes");
%>

<jsp:useBean id="logcat" class="com.spaneos.online_shopping.CategoryBean" scope="request"> 
<jsp:setProperty property="cat" name="logcat" value="<%=catg%>"/>
<jsp:setProperty property="des" name="logcat" value="<%=desc%>"/>
</jsp:useBean>
<jsp:forward page="addCategory.Ado"/>
</body>
</html>

<%-- <% 
String catg=request.getParameter("newcat");  
String desc=request.getParameter("newdes");
%>
   <jsp:setProperty property="cat" name="logcat" value="<%=catg%>"/>
<jsp:setProperty property="des" name="logcat" value="<%=desc%>"/>                                               
 --%>


