<%@page import="com.cbm.bean.Item"%>
<%@page import="com.cbm.dao.PrePopulation"%>
<%@page import="com.cbm.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Common Bill Management</title>

<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Common Bill Management</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
					<li><a href="#">About</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	
	<%
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Item> items = new ArrayList<Item>();
		int balance=0;
		if(request.getAttribute("UserList") != null){
		users = (ArrayList<User>)request.getAttribute("UserList");
		}
		if(request.getAttribute("ItemList") != null)
			items = (ArrayList<Item>)request.getAttribute("ItemList");
		if(request.getAttribute("currentBalance") != null)
			balance = Integer.parseInt(request.getAttribute("currentBalance").toString());
					
					
	%>
	
	<!-- Stats  -->
	<div class="container-fluid">
		<div class="row">
		<div class="col-xs-12 col-md-6">
			<div class="col-xs-12 col-md-12">
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Enter Transactions
					<span class="badge">Current Balance : <%=balance %></span>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post" action="InsertTranx">
							<div class="form-group">
								<label for="itemname" class="col-sm-2 control-label">Item</label>
								<div class="col-sm-10">
									<select class="form-control" name="itemDropDown">
										<option>Select items</option>
										<%
										
										for(int i = 0; i<items.size(); i++){
										%>
										<option value="<%=items.get(i).getItemId()%>"><%=items.get(i).getItemName() %></option>
										<%} %>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">Person</label>
								<div class="col-sm-10">
									<select class="form-control" name="userDropDown">
										<option>Select Person</option>
										<%
										request.setAttribute("userList", users);
										for(int i = 0; i<users.size(); i++){
										%>
										<option value="<%=users.get(i).getUserId()%>"><%=users.get(i).getUserName() %></option>
										<%} %>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="amount" class="col-sm-2 control-label">Amount</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" name="amount"
										placeholder="Enter Amount spent">
								</div>
							</div>
							<div class="form-group">
								<label for="summary" class="col-sm-2 control-label">Summary</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" name="summary"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">Enter Transaction</button>
									<input type="hidden" value="InsertTranx" name ="action" >
									<input type="hidden" value="<%=balance %>" name="balance" >
								</div>
							</div>
						</form>
					</div>
					<!-- Table -->
					<table class="table table-bordered">
						<tr>
							<th>Col1</th><th>Col1</th><th>Col1</th><th>Col1</th>
						</tr>
						<tr class="active">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="active">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="active">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="active">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td><td>shell</td><td>shell</td><td>shell</td>
						</tr>
					</table>
				</div>
			</div>
			</div>
			<div class="col-xs-12 col-md-6">
			<div class="col-xs-12 col-md-12">
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Deposit Money</div>
					
					<div class="panel-body" >
						<form action="DepositMoney" class="form-horizontal" method="post">
							<div class="form-group">
								<label for="tranx" class="col-sm-2 control-label">TXN Type</label>
								<div class="col-sm-10">
									<select class="form-control" name="tranxType">
										<option value="1">Credit</option>
										<option value="0">Debit</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">Person</label>
								<div class="col-sm-10">
									<select class="form-control" name="userDropDown">
										<option>Select Person</option>
										<%
											request.setAttribute("userList", users);
											for (int i = 0; i < users.size(); i++) {
										%>
										<option value="<%=users.get(i).getUserId()%>"><%=users.get(i).getUserName()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="amount" class="col-sm-2 control-label">Amount</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" name="amount"
										placeholder="Enter Amount spent">
								</div>
							</div>
							<div class="form-group">
								<label for="summary" class="col-sm-2 control-label">Summary</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" name="summary"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">Deposit Money</button>
									<input type="hidden" value="InsertTranx" name="action">
									<input type="hidden" value="<%=balance%>" name="balance">
								</div>
							</div>
						</form>
					</div>

					<!-- Table -->
					<table class="table table-bordered">
						<tr class="active">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						<tr class="active">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						
					</table>
				</div>
			</div>
			
			
			<div class="col-xs-12 col-md-12">
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Panel heading</div>

					<!-- Table -->
					<table class="table table-bordered">
						<tr class="active">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						<tr class="active">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						<tr class="success">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
						<tr class="active">
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
							<td>shell</td>
						</tr>
					</table>
				</div>
			</div>
			</div>
		</div>
		
		<!--MY SCRIPTS 
		<script>
			var xmlhttp = new XMLHttpRequest();
			var url = "http://localhost:8088/CommonBill/Populate";

			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var myArr = JSON.parse(xmlhttp.responseText);
					myFunction(myArr);
				}
			}
			xmlhttp.open("GET", url, true);
			xmlhttp.send();

			function myFunction(arr) {
				var out = "";
				var i;
				for (i = 0; i < arr.length; i++) {
					out += '<option value="' + arr[i].UserId + '">' + arr[i].Name
							+ '</option>';
				}
				document.getElementById("id01").innerHTML = out;
			}
		</script> -->


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
</html>