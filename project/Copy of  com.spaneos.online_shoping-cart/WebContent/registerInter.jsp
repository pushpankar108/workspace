<jsp:useBean id="reg" class="onlineshopping.user.RegisterBean"
	scope="request">
	<jsp:setProperty name="reg" property="*" />
</jsp:useBean>
<jsp:forward page="register.Udo" />