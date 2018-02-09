
<%
	String pname = request.getParameter("pname1");
	String pdes = request.getParameter("pdes");
	String pcat = request.getParameter("pcat");
	String ppno = request.getParameter("pno");
	String pprice = request.getParameter("price");
	int pno = Integer.parseInt(ppno);
	int price = Integer.parseInt(pprice);
%>

<jsp:useBean id="logprod" class="online_shopping.productBean"
	scope="request">
	<jsp:setProperty property="pname" name="logprod" value="<%=pname%>" />
	<jsp:setProperty property="pdes" name="logprod" value="<%=pdes%>" />
	<jsp:setProperty property="pcat" name="logprod" value="<%=pcat%>" />
	<jsp:setProperty property="pno" name="logprod" value="<%=pno%>" />
	<jsp:setProperty property="price" name="logprod" value="<%=price%>" />
</jsp:useBean>
<jsp:forward page="editProduct1.Ado" />
