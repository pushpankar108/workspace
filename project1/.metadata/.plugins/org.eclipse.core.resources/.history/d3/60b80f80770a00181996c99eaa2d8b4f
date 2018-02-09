
<%
	String uid = request.getParameter("uid");
	String ps = request.getParameter("psw");
%>
out.println("here");
<jsp:useBean id="log" class="onlineshopping.user.UserBean"
	scope="request">
	<jsp:setProperty property="name" name="log" value="<%=uid%>" />
	<jsp:setProperty property="pass_word" name="log" value="<%=ps%>" />
</jsp:useBean>
<jsp:forward page="loginUser.Udo" />
