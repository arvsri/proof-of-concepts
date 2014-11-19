<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<div>loading forum .. please wait</div>
		<form id="forwadForm" action="http://disqus.forumchitchat.com/" method="get"></form>
		<img id="authImag" src="http://disqus.websitetoolbox.com/register/dologin?authtoken=${response.authtoken}" border="0" width="1" height="1" alt="" />

  		<script src="http://test-anucana1.rhcloud.com/static/js/jquery1.9.1.min.js"></script>
  		<script type="text/javascript">
		  	$(document).ready(function(){
		  		$("#authImag").on("error",function(){
		  			$("#forwadForm").submit();
		  		});
		  	});
	  	</script>
	</body>
</html>