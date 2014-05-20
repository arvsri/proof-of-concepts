<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<h1>Enter your details here</h1>
<%
	String str = "<br>";
	Enumeration enumeration = request.getAttributeNames();
	while(enumeration.hasMoreElements()){ 
		String attrName =  enumeration.nextElement().toString();
	%>	
		<%=str %><%=str %>
		<%=attrName %>
		<%=str %>
		<%=request.getAttribute(attrName) %>
	
	<%}%>
<form:form method="post" action="operate" commandName="userLogin">
	<table>
		<tr><td>First Name : </td><td><form:input path="firstName" maxlength="50" ></form:input></td><td><form:errors path="firstName" /></td></tr>
		<tr><td>Last Name : </td><td><form:input path="lastName" maxlength="50" ></form:input></td><td><form:errors path="lastName" /></td></tr>
		<tr><td>User Name : </td><td><form:input path="username" maxlength="20" ></form:input></td><td><form:errors path="username" /></td></tr>
		<tr><td>Password : </td><td><form:password path="password" maxlength="20"></form:password></td><td><form:errors path="password" /></td></tr>
		<tr><td>Reenter Password : </td><td><form:password path="passwordRepeat" maxlength="20"></form:password></td><td><form:errors path="passwordRepeat"/></td></tr>
		<tr><td colspan="1"><input type="hidden" name="ops" value="${ops}"></input></td></tr>
		<tr><td><input type="submit" name="Submit"></input></td><td><input type="reset" name="Clear"></td></tr>
	</table>
</form:form>
</body>
</html>