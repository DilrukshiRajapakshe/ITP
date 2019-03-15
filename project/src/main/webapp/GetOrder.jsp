<!-- IT17123778– Wickramanayaka D.T.A -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/all.css">
    <link rel="stylesheet" href="resources/css/Order.css">
    
    <link rel="stylesheet" href="resources/css/fonts.css">
    <script src="resources/js/jQuery.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/properjs.js"></script>
    <script src="resources/js/bootstrao.awsom.font.js"></script>
    <script src="resources/js/bootstrao.awsom.font.bundle.js"></script>
    <script src="resources/js/jquery3.3.1.min.js"></script>
    <script src="resources/js/bootstrap4.1.0.min.js"></script>
    <title>Order & Delivery Management</title>
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
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
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
                <div class="col-sm-2  my-col2 ">
                       <div class="row"><a href="index1.jsp" target="_self" class="link1"><i class="fas fa-server"></i>&ensp; DashBoard</a></div>
                       <div class="row"><a href="user.jsp" target="_self" class="link1"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="StockItemManagement.jsp" target="_self" class="link1"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="profit.jsp" target="_self" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link2"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  my-col3 ">
                        <br>
                    <h1 style="text-align: center">GET ORDER</h1>
                    <br>
                    <form style="text-align:center" action="orderInsert" method="post">                      
					<input type="hidden" name="no" value="976">
					<input type="hidden" name="name" value="Namal">
					<input type="hidden" name="address" value="Gampaha">
					<input type="hidden" name="contact" value="0774550059">
					<input type="hidden" name="item" value="Sand">
					<input type="hidden" name="quantity" value="5">
					<input type="hidden" name="amount" value="10000">
					<input type="hidden" name="delivery" value="3000">
					<button type="submit" class="btn btn-outline-secondary" id="createbutton" name ="st" value="add">Demo</button>			
					</form>	
					<br>
                    <table class="table">
                        <tr>
                            <td>
                    <form style="text-align:center" action="orderInsert" method="post">
                        <div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Order No</span>
                          </div>
                          <input type="text" class="form-control" placeholder="Enter order no" id="input1" name="no">
                        </div>
						
                            <div class="input-group mb-3">
                              <div class="input-group-prepend">
                                <span class="input-group-text"  id="input1">Customer Name</span>
                              </div>
                              <input type="text" class="form-control" placeholder="Enter Customer Name  " id="input2" name="name"pattern="[A-Za-z]{1,50}" title="Enter customer name">
                            </div>
                          
                                <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1">Address</span>
                                  </div>
								   <input type="text" class="form-control" placeholder="Enter Address  " id="input2" name="address"pattern="[A-Za-z]{1,50}" title="Enter customer address">
                            </div>
								   <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1">Contact No</span>
                                  </div>
								   <input type="text" class="form-control" placeholder="Enter Contact No  " id="input2" name="contact"pattern="[0-9]{10}" title="contact number ">
                            </div>
								  <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1">Order Items </span>
                                  </div>
                                  <input type="text" class="form-control" placeholder="Enter Order Items" id="input2" name="item"pattern="[A-Za-z]{1,50}" title="Enter customer oeder items">
                                </div>
                                <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1">Item Quantity</span>
                                  </div>
                                  <input type="text" class="form-control" placeholder="Enter Item Qantity" id="input2" name="quantity"pattern="[0-9]{1,10}" title="Enter Item quantity">
                                </div>
								 <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1">Item price </span>
                                  </div>
                                  <input type="text" class="form-control" placeholder="Enter Item price" id="input2" name="amount"pattern="[0-9]{1,10}" title="Enter amount of order">
                                </div>
								 <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1">Delivery Charges </span>
                                  </div>
                                  <input type="text" class="form-control" placeholder="Enter Delivery Charges" id="input2" name="delivery"pattern="[0-9]{1,10}" title="Enter Delivery Charges">
                                </div>
                                <br>
                                <button type="submit" class="btn btn-outline-secondary" id="createbutton" name ="st" value="add">Calculate</button>
                                <br>
                                </form>
                                <form style="text-align:center">
								 <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="input1" name="final">Final Amount </span>
                                  </div>
                                  <input type="text" class="form-control" placeholder="Final Amount " id="input2" name="final"pattern="[0-9]{1,10}" title="Enter Final amount">
                                </div>
                                <button type="submit" class="btn btn-outline-secondary" id="createbutton" name ="st" value="add">save</button>					
                              </form>
                            </td>
                            </tr>
                            </table>
                </div>
              
        </div>
        
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
</body>
</html>