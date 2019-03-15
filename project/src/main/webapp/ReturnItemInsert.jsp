<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" java.util.Date" %>
<%@ page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/all.css">
    <link rel="stylesheet" href="resources/css/mystyle.css">
    <link rel="stylesheet" href="resources/css/fonts.css">
    
    <script src="resources/js/jQuery.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/properjs.js"></script>
    <script src="resources/js/bootstrao.awsom.font.js"></script>
    <script src="resources/js/bootstrao.awsom.font.bundle.js"></script>
    <script src="resources/js/jquery3.3.1.min.js"></script>
    <script src="resources/js/bootstrap4.1.0.min.js"></script>
   
    <title>Return Item Information</title>
    
    <style>
	    #createbutton{
	        width: 150px;
	    }
	    #input1{
	        width:200px;
	    }
	    .input2{
	        width:400px;
	        padding-right: 50px;
	    }
	    input[type=text]{
	        width:200px;
	    }
	    .table{
	        border:2px solid #9fa8a3;
	        width: 100%;
	        
	    }
	    #input3{
	        width:800px;
	        padding-right: 50px;
	    }
    </style>
    
</head>
<body>
<div class="contaianer">
        <div class="row my-row1">
        <% user currentUser = (user)(session.getAttribute("currentSessionUser"));%>
            <div class="col-sm-10 "><h1 class="banner"><i class="fas fa-screwdriver"></i>Shakthi <i class="fas fa-gavel"></i> Hardware<i class="fas fa-shipping-fast"></i></h1>
            
            	
            </div>
            <div class="col-sm-2 my-logout">
                    <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="button1">
                                    <i class="fas fa-user"></i>
                            </button>
                                <div class="dropdown-menu">
                                    
                                    <a class="dropdown-item" href="logOut" class="dropdown-logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</a>
                                </div>
                                <br>
                                Welcome <%= currentUser.getUname() + " !!"%>	
                    </div>
            </div>
        </div>
        <div class="row my-row6">
                <div class="row my-row6">
                <div class="col-sm-2  my-col2 ">
                       <div class="row"><a href="index1.jsp" target="_self" class="link1"><i class="fas fa-server"></i>&ensp; DashBoard</a></div>
                       <div class="row"><a href="user.jsp" target="_self" class="link1"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="StockItemManagement.jsp" target="_self" class="link2"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="profit.jsp" target="_self" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  card border-info">
                        <br>
                    
                    <table>
	                 <thead>
	                 	<tr>
	                    	<th><h1 style="margin-right: 450px">Return Item Information</h1></th>
	                    	<th >
		                    	<form action="ReturnInsert" method="post">
		                    		<input type="hidden"  name="name" value="kumari" >
									<input type="hidden"  name="Id" value="101" >
									<input type="hidden"  name="supplierID" value="df3" >
									<input type="hidden"  name="cuName" value="kumari" >
									<input type="hidden"  name="telNo" value="1234567890" >
									<input type="hidden"  name="sellprice" value="10" >
									<input type="hidden"  name="amount" value="10" >
									<input type="hidden"  name="date" value="2018-09-30 " >
									<input type="hidden"  name="today" value="2018-10-30 " >
									<input type="hidden"  name="type" value="Return-item" >
								
		                    		<button type="submit" class="btn" id="createbutton" name ="st" value="Insert">Insert</button>
		                    	</form>
	                    	</th>
	                    </tr>
	                  </thead>
	                </table>
                    <table class="table">
                        <tr>
                            <td>
								<form style="text-align:center" action="ReturnInsert" method="post" name="myForm" >
									<div class="input-group mb-3">
									  <div class="input-group-prepend">
										<span class="input-group-text" id="input1" value="a"  >Name</span>
									  </div>
									  <input type="text" class="form-control"  id="input2"name="name" pattern="^[a-zA-Z0-9_]+$">
									</div>
								  
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"  id="input1"value="b" >Item ID</span>
										</div>
										<input type="text" class="form-control" id="input2"name="Id" pattern= "[0-9]*[0-9]*[0-9]*[0-9]" title="Numbers only">
									</div>
									 
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="input1" value="c">Supplier ID</span>
										</div>
										<input type="text" class="form-control" id="input2"name="supplierID" pattern="^[a-zA-Z0-9_]+$">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"  id="input1" value="d">Customer Name</span>
										</div>
										<input type="text" class="form-control" id="input2"name="cuName" pattern="^[a-zA-Z0-9_]+$">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"  id="input1" value="d">Customer Telephone No</span>
										</div>
										<input type="text" class="form-control" id="input2"name="telNo" pattern= "[0-9]{10}" title=" 10 Numbers only">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"  id="input1" value="e">Sell Price</span>
										</div>
										<input type="text" class="form-control"id="input2"name="sellprice" pattern="^\d+(?:,\d{3})*\.\d{2}" title="Two digit requred">
									</div>
										
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"  id="input1" value="f">No of Items Amount</span>
										</div>
										<input type="text" class="form-control"id="input2"name="amount" pattern= "[0-9]*[0-9]*[0-9]" title="Numbers only">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"  id="input1" value="q">Sold date</span>
										</div>
										<div>
										      <input id="input-datetime-local" type="date" class="form-control" value="2018-09-06"  id="input3"name="date" >
										</div>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
										<div class="input-group-prepend" >
											<span  class="input-group-text"  id="input1" value="q" >Today date</span>
										</div>
										<div>
										      <input id="input-datetime-local" type="date" class="form-control" value="2018-09-06" id="input3"name="today" >
										</div>
									</div>
									<div class="input-group mb-3">
									    <div class="input-group-prepend">
											<span class="input-group-text"  id="input1" value="g">Type</span>
										</div>
									    <select class="form-control" id="sel1"name="type" required >
									    	<option Value=""></option> 
											<option value="Return-item">Return item</option>
											<option value="Reparing-item">Repaired item</option>
											<option value="NonReparing-item">Non-Repaired item</option>
										</select>
									</div>	
									<button type="Reset" class="btn" id="createbutton" >Reset</button>
									<button type="submit" class="btn" id="createbutton"name="st" value="Insert">Insert</button>
								</form>
                            </td>
                        </tr>
                    </table>
                    <form align="center" action="ViewAction" method="post">
                    	<button type="View" class="btn" id="createbutton" name="st" Value="ReturnView">View</button>
						<button type="Reports" class="btn" id="createbutton" name="st" Value="Reports">Reports</button>
						<button type="Search" class="btn" id="createbutton" name="st" Value="Search">Search</button>
        			</form>
                </div> 
        </div>
        
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
</body>
</html>