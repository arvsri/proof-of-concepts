<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>anucana</title>
</head>
<body>
	<h3> Home </h3>
	<h3> This is home page. Your can login or register from here</h3>
	
	<h4> ------------- Login Here -----------------</h4>
   	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
        <div class="errorblock" style="color:red;font-size: 16px;font-style: Bold">
            Your login attempt was not successful, try again.<br /> Caused : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/><br /><br />
        </div>
    </c:if>	
	
	<form action="login" method="post">
		User Name : <input type="text" name="username" />
		Password : <input type="password" name="password" />
		<input type="submit" name="Submit"></input>
		<input type="reset" name="Reset"></input>
	</form>


</body>
</html>
