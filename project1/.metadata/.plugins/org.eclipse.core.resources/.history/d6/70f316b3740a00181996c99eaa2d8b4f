<%  
    String name=request.getParameter("name");
    String des=request.getParameter("des");  
    
    %>
    
    <jsp:useBean id="logcat" class="online_shopping.CategoryBean" scope="request">  
    <jsp:setProperty property="cat" name="logcat" value="<%=name %>"/>
    <jsp:setProperty property="des" name="logcat" value="<%=des %>"/>
     
    </jsp:useBean>
    <jsp:forward page="edit1.Ado"/> 