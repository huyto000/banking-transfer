<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/transaction.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</head>
<body>
	
	
	<div class='container'>
		
		<div class='jumbotron text-center' id = 'jumbotron'>
		<h1><b>Banking System</b></h1>
		</div>
		<div id = 'center'>
		<div id = 'left'>
		
		<div id='hello' style = 'color:red'>${account.getAccount()}</div>
	
		<div id = 'trans_log'>	
		<a href="javascript:void(0)" id = 'btn-transfering'>Transfering</a><br>
		<a href="javascript:void(0)" id = 'btn-transfer'>Transfer History</a><br>
		<a href="javascript:void(0)" id = 'change_password'>Change Password</a><br>
		<a href="logout">Logout</a>
		</div>
		</div>
		<div id = 'right'>
		<div id = "right-inside">
		<form name = 'frm-transfer' action = '#' method = "POST" >
		<div class="form-group">
			
				<b>Your Balance</b> 	
				<td><input type="text" name="balance" id = "balance-now" class = 'form-control' value ="${balanceValue}" disabled/></td>
				
		</div>
		<div class="form-group">
				
				<b>Enter Ammount</b>
			
					
					<td><input type="text" name="amount" placeholder="Enter Amount" id = "amount" class = 'form-control' onblur = "return validate()"><span id ='err-amount'></span></td>
		</div>
		<div class="form-group">
			<b>Select Account to transfer</b>
			
					
				<select name = 'account_transfer' id = 'account_transfer' class="form-control" onclick='remove()' required><span id ='err-account-transfer' ></span>		
						<option value ="">Choose Account</option>
						<c:forEach items="${listAccount}" var="acc">
					
						<option value = '${acc.getAccount()}'>${acc.getAccount()}</option>
				</c:forEach>
	
					</select>
			</div>
			<div class="form-group">
				<b>Transaction Note</b>
		
					
			<!--  	<input type="text" name="note" id = "note" class = 'form-control'>-->
				<textarea name = "note" class="form-control" rows="5" id="note"></textarea>
			
			</div>
			<button type = 'submit' id = 'btn-transfer-post' class="btn btn-primary" onclick = "return validate()">Transfer</button>
		
		</form>
		</div>
		${message}
		</div>
		</div>
		
	</div>
	<script>
		
	</script>
	<script language="javascript" src="<%=request.getContextPath()%>/resources/js/transaction.js"></script>
	<script>
		$(document).ready(function() {
			$("#btn-transfering").click(function() {
				//var userName = $("#hello").html();
				var userName = '<c:out value="${account.getAccount()}"/>';
				//var balance = $()
				$.ajax({
						type:'GET',
						url :'transfering',
						data : {
							"userName" : userName							
						}, 
						success:function(response) {
							$("body").html(response);
						}
					});  	
			}); 
			
			 $("#btn-transfer-post").click(function(a) {
 				if(validate()){
				 alert('Transfer Successfully!');
 				}
 				//var userName = $("#hello").html();
 				var userName = '<c:out value="${account.getAccount()}"/>';
				var amount = $("#amount").val();
				var account_receive = $("#account_transfer").val();
				var note = $("#note").val();
				var account_transfer = $("#hello").html();
				$.ajax({
					url : 'add-transfer',
					type : 'POST',
					data : {
						"userName":userName,
						"amount" : amount, 
						"note" : note,
						"account_receive" : account_receive,
						"account_transfer" : account_transfer
					},
					success : function(response) {
						
						$("#right-inside").html(response);
					}
				})
				a.preventDefault();
			}) 
			
			$("#btn-transfer").click(function() {
				//var userName = $("#hello").html();
				var userName = '<c:out value="${account.getAccount()}"/>';
			$.ajax({
		        type: "GET",
		        data:{
		        	"userName":userName
		        },
		        url: "show-transfer",	       
		        success: function(response) {
		            $('#right-inside').html(response); 
		        }
		    });
		});
			 $("#change_password").click(function() {		
					$.ajax({
				        type: "GET",
				        url: "change-pass",		       
				        success: function(response) {
				            $('#right-inside').html(response); 
				        }
				    });
				}); 
		});
			</script>
			<script>
			 function validate(){
				var temp = false;
				
				var balance = document.getElementById('balance-now');
				var amount = document.getElementById('amount');
				var account_transfer = document.getElementById('account_transfer');
				var errAccountTransfer = document.getElementById('err-account-transfer');
				var errAmount = document.getElementById('err-amount');
				
				if(amount.value==''){
					amount.style.border = '1px solid red';
					errAmount.innerHTML = 'Please enter amount!';
					errAmount.style.color="red";
					temp = false;
				}
				else {
					if( parseInt(amount.value) > parseInt(balance.value)){
						amount.style.border = '1px solid red'; 
						errAmount.innerHTML = 'Please amount less than Balance!';
						 errAmount.style.color="red";
						temp = false;
					}
					else {
						amount.style.border = '1px solid green';
						errAmount.innerHTML = '';
						temp = true;
					}  
				}
				 
				return temp;
			}
 		</script>
</body>
</html>