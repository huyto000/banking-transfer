<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/transaction.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</head>
<body>
	<div id = 'container'>
		<div id = 'header1' ><h1><b>Banking System</b></h1></div>
	<form name = 'frm-login' action = '<%=request.getContextPath()%>/login' method = "POST" >
			<div class = 'form-group'>
				<b>Account</b> <span>*</span>
			
					
			<input type="text" name="username" placeholder="Enter Account" class = "form-control"><span id ='err-account'></span>
			</div>
			<div class = 'form-group'>
				<b>Password</b><span>*</span>
		
					
			<input type="password" name="password" placeholder="Enter Password" class='form-control'><span id ='err-password'></span>
				
			</div>
					
				<button type = 'submit'>Login</button>
				
		</form>
	</div>	
	<p style = "text-align:center" id='err-login'>${error}</p>
</body>
</html>