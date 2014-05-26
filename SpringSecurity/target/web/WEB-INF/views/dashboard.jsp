<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>anucana</title>
</head>
<body>
	Hello <security:authentication property="principal.firstName" /> <security:authentication property="principal.lastName" />!
	<h3> Dashboard </h3>
	<h3> you can reach here only after logging in </h3>

	<ul>
		<security:authorize access="hasRole('ur_gu')">
			<li><a href="/TestWar/managed/changepassword">Change Password</a></li>
		</security:authorize>
		<security:authorize access="hasRole('ur_cmo')">
			<li><a href="/TestWar/managed/createAnEvent">Create An Event</a></li>
		</security:authorize>
		<security:authorize access="hasRole('ur_a')">
			<li><a href="/TestWar/managed/suspendOtherUser">Suspend other Users</a></li>
		</security:authorize>
		<li><a href="/TestWar/logout">Logout</a></li>
	</ul>

</body>
</html>
