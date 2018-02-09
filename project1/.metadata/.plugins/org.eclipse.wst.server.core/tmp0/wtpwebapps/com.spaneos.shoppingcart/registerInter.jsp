<%
	
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	String rpass = request.getParameter("rpass");
%>

<jsp:useBean id="reg" class="com.spaneos.onlineshopping.user.RegisterBean" scope="request">
	<jsp:setProperty name="reg" property="*" />
</jsp:useBean>
<jsp:forward page="register.Udo" />







