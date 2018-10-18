<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</head>
<body>
	<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Amount</th>
					<th>Transaction Note</th>
					<th>Account Receive</th>
					<th>Account Transfer</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
			
				 <c:forEach items= "${listTransfer}" var="list">	
					<tr>
						<td>${list.id}</td>
						<td>${list.amount}</td>
						<td>${list.transactionNote}</td>
						<td>${list.accountReceive}</td>
						<td>${list.accountTransfer}</td> 	
						<td><span class="glyphicon glyphicon-trash" id='trash_${list.id}'></span></td>	
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		<script>
		$(document).ready(function() {
			$("span").click(function(e) {
				//var userName = $("#hello").html();
				var userName = '<c:out value="${account.getAccount()}"/>';
				var id = $(this).attr("id").slice(6);
				
				//var balance = $()
				$.ajax({
						type:'GET',
						url :'delete-row',
						data : {
							"id" : id,
							"userName":userName
						},
						success:function(response) {
							$('#right-inside').html(response);
						}
					});
					
			}); 
		}); 
			</script>
</body>
</html>