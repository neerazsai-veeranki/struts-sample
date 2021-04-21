<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="login-box">
    <h1 class="title">Login Form</h1> 
    <div class="login-form">
        <%-- cssClass="login-form" --%>
        <s:form action="users/UserLogin" 
        >
            <s:textfield name="name" label="User Name"></s:textfield>
            <s:password name="pass" label="Password"></s:password>
            <s:submit value="save"></s:submit>
        </s:form>
    </div>
</div>
    
</body>
</html>