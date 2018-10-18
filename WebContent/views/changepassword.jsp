<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
 <!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  -->
</head>
<body>
<div class = "changepassside">
<form name = 'frm-changepassword' method= "POST" id="form11">
	
	<div class="form-group">
			
				<b>Old PassWord</b> 	
				<input type="password" name="oldpass"  placeholder="Enter Old Password"  id = "oldpass" class = 'form-control' onblur="return checkOldPass()"/><span id='oldpass_error'></span>
				
		</div>
		<div class="form-group">
				
				<b>New Pasword</b>
					<input type="password" name="newpass" placeholder="Enter New Password" id = "newpass" class = 'form-control' onblur = 'return checkNewPass()'><span id = 'newpass_error'></span>
		</div>
		<div class="form-group">
				
				<b>Confirm New Pasword</b>
					<input type="password" name="cf_newpass" placeholder="Confirm New Password" id = "cf_newpass" class = 'form-control' onblur = 'return checkConfirmPass()'><span id = 'cf_newpass_error'></span>
		</div>
		<div class="form-group">
				
			<button type="submit" class="btn btn-primary" id = 'btn_changepass' onclick='return checkPassAll()'>Change PassWord</button>	
		</div>
		</form>
		</div>
		<script>
		 $(document).ready(function() {
			$("#btn_changepass").click(function(a) {
				//var userName = $("#hello").html();
				a.preventDefault();
				a.stopPropagation();
				//var userName = '<c:out value="${account.getAccount()}"/>';
				var userName = '${account.getAccount()}';
				var newPass = $("#newpass").val();
				
				//var balance = $()
				alert(newPass);
				$.ajax({
						type:'POST',
						url :'change-pass',
						data : {
							"user_name":userName,
							"new_pass":newPass,
							
						},
												
					 
						success:function(response) {
							$("body").html(response);
						}
						
					}); 
				return;
				
			}); 
		}); 
			 
			</script>
			<script>
			var currentPass = '<c:out value="${account.password}"/>';
			//var currentName = '<c:out value="${account.getAccount()}"/>';
			function checkOldPass(){
				var oldPass = document.getElementById('oldpass');
				var oldPassError = document.getElementById('oldpass_error');
				if(oldPass.value !== currentPass){
					oldPass.style.border='1px solid red';
					oldPassError.style.color = 'red';
					oldPassError.innerHTML = 'Please enter Old Password!';
					return false;
				}
				else {
					oldPass.style.border='1px solid green';	
					oldPassError.innerHTML = '';
					return true;
				}
			}
			
			
			 function checkNewPass(){
				var newPass = document.getElementById('newpass');
				var newPassError = document.getElementById('newpass_error');
				if(newPass.value == currentPass || newPass.value == ''){
					newPass.style.border='1px solid red';	
					newPassError.innerHTML='Please enter New Password!';
					newPassError.style.color = 'red';
					return false;
				}
				else {
					newPass.style.border='1px solid green';	
					newPassError.innerHTML='';
					return true;
				}
			 }
				
				 function checkConfirmPass(){
					var cfNewPass = document.getElementById('cf_newpass');
					var newPass = document.getElementById('newpass');
					var cfNewPassError = document.getElementById('cf_newpass_error');
					if(cfNewPass.value !== newPass.value || cfNewPass.value=='' ){
						cfNewPass.style.border='1px solid red';	
						cfNewPassError.innerHTML='Please Confirm New Password!';
						cfNewPassError.style.color = 'red';
						return false;
					}
					else {
						cfNewPass.style.border='1px solid green';	
						cfNewPassError.innerHTML='';
						return true;
					}
			}
				 function checkPassAll(){
					return checkOldPass() && checkNewPass() && checkConfirmPass();	
				 }
			
			
		 
		</script>
</body>
</html>