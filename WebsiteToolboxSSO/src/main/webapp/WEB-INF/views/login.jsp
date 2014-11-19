<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>anucana</title>
</head>
<body>
	<c:if test="${not empty errorMessage}">
 	    <h4 style="color:#FF614D">
     	   	<img src="http://test-anucana1.rhcloud.com/static/images/icons/login_error_black.png" />&nbsp;&nbsp;<c:out escapeXml="false" value="${errorMessage}"/>
         </h4>
	</c:if>
	<h3> This is home page.</h3>
	
	<h3>  ------------------- Login Section -------------------------------------- </h3>
	<c:if test="${not empty loginErrorMessage}">
 	    <h4 style="color:#FF614D">
     	   	<img src="http://test-anucana1.rhcloud.com/static/images/icons/login_error_black.png" />&nbsp;&nbsp;<c:out escapeXml="false" value="${loginErrorMessage}"/>
         </h4>
	</c:if>
	<form action="${pageContext.request.contextPath}/forumLogin" method="post"> 
		<table>
		<tr>
			<td>Please enter your user name</td>
			<td><input type="text" name="username"></input></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="Submit" value="Take me to the forum"></input></td>
		</tr>
		</table>
	</form>
	
	<h3>  ------------------- New User Registration Section -------------------------------------- </h3>
	<c:if test="${not empty registrationErrorMessage}">
 	    <h4 style="color:#FF614D">
     	   	<img src="http://test-anucana1.rhcloud.com/static/images/icons/login_error_black.png" />&nbsp;&nbsp;<c:out escapeXml="false" value="${registrationErrorMessage}"/>
         </h4>
	</c:if>
	<form action="${pageContext.request.contextPath}/forumRegister" method="post"> 
		<table>
		<tr>
			<td>Please enter your name</td>
			<td><input type="text" name="name"></input></td>
		</tr>
		<tr>
			<td>Please enter your user name</td>
			<td><input type="text" name="username"></input></td>
		</tr>
		<tr>
			<td>Please enter your password</td>
			<td><input type="text" name="password"></input></td>
		</tr>
		<tr>
			<td>Please enter your email address</td>
			<td><input type="text" name="email"></input></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="Submit" value="Register me to the forum"></input></td>
		</tr>
		</table>
	</form>
	
</body>
</html>
