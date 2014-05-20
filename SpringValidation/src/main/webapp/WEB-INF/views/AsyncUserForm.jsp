<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Async Login Form </title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

</head>
<body>

	<form:form method="post" action="user/create" commandName="userLogin">
		<table>
			<tr><td>First Name : </td><td><form:input path="firstName" maxlength="50" ></form:input></td><td><span class="error" id="firstNameError"></span></td></tr>
			<tr><td>Last Name : </td><td><form:input path="lastName" maxlength="50" ></form:input></td><td><span class="error" id="lastNameError"></span></td></tr>
			<tr><td>User Name : </td><td><form:input path="username" maxlength="20" ></form:input></td><td><span class="error" id="usernameError"></span></td></tr>
			<tr><td>Password : </td><td><form:password path="password" maxlength="20"></form:password></td><td><span class="error" id="passwordError"></span></td></tr>
			<tr><td>Reenter Password : </td><td><form:password path="passwordRepeat" maxlength="20"></form:password></td><td><span class="error" id="passwordRepeatError"></span></td></tr>
			<tr><td><input type="submit" name="Submit"></input></td><td><input type="reset" name="Clear"></td></tr>
		</table>
	</form:form>


  <script type="text/javascript">
	  $(document).ready(function(){
		  $("form").submit(function(event){
					
			  	event.preventDefault();

			  	var form = $(this);
				var url = form.attr("action");
				var dataForSubmission = form.serialize();
				
				$.ajax({
					headers: { "Accept" : "application/json; charset=utf-8",         
		                	   "Content-Type" : "text/plain; charset=utf-8"   
		  					 },					
					type: "POST",
					url: url,
					data: dataForSubmission,
					dataType: "json",
					success: function(response){
						if(response.viewError != 'undefined' && response.viewError.fieldErrors != 'undefined' && response.viewError.fieldErrors.length != 0){
							// handle error first
							$.each(response.viewError.fieldErrors,function( key, value ){
								form.find("#" + value.field + "Error").text(value.errorMessage);
							});
						}
					},
					error: function(response){
						console.log("Error occured in ajax call");
						console.log(response);
					}
				});
			});
	  });
  </script>	
</body>
</html>