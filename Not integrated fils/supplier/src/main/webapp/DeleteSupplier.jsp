<%@page import="java.io.ObjectStreamException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
	<%@ page import="com.model.supplier" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/all.css">
    <link rel="stylesheet" href="resources/css/Supplier.css">
    
    <link rel="stylesheet" href="resources/css/fonts.css">
    <script src="resources/js/jQuery.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/properjs.js"></script>
    <script src="resources/js/bootstrao.awsom.font.js"></script>
    <script src="resources/js/bootstrao.awsom.font.bundle.js"></script>
    <script src="resources/js/jquery3.3.1.min.js"></script>
    <script src="resources/js/bootstrap4.1.0.min.js"></script>
    <title>Supplier</title>
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
<div class="contaianer">
        <div class="row my-row1">
            <div class="col-sm-10 "><h1 class="banner"><i class="fas fa-screwdriver"></i>Shakthi <i class="fas fa-gavel"></i> Hardware<i class="fas fa-shipping-fast"></i></h1></div>
            <div class="col-sm-2 my-logout">
                    <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="button1">
                                    <i class="fas fa-user"></i>
                            </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#" class="dropdown-logout"><i class="fas fa-user"></i>&ensp;User Profile</a>
                                    <a class="dropdown-item" href="#" class="dropdown-logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</a>
                                </div>
                    </div>
            </div>
        </div>
        <div class="row my-row6">
                <div class="col-sm-2  my-col2 ">
                       <div class="row"><a href="Test1.html" target="_self" class="link1"><i class="fas fa-server"></i>&ensp; DashBoard</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="addEmployee.html" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;View Reports</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
					   <div class="row"><a href="addSupplier.html" target="_self" class="link2"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  my-col3 ">
                        <br>
                    <h1 style="text-align: center">Remove Supplier</h1>
                    <%
						  int Total = 0;
	                      int count = 0;
							if (request.getAttribute("result") != null) {
								ArrayList al = (ArrayList) request.getAttribute("result");
	                            System.out.println(al);
								Iterator itr = al.iterator();
								while (itr.hasNext()) {          
									count++;
									ArrayList list = (ArrayList)itr.next();
                    %>
                    <br>
                    <table class="table">
                        <tr>
                            <td>
                    <form style="text-align:center"action="delete" method="post">
                        <div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Supplier ID</span>
                          </div>
                          <input type="text" class="form-control" name="id" placeholder="Enter Remove Supplier ID" id="input2" value="<%=list.get(0)%>">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Supplier Name</span>
                          </div>
                          <input type="text" class="form-control" name="name" placeholder="Enter Remove Supplier Name" id="input2" value="<%=list.get(1)%>">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >E-Mail Address</span>
                          </div>
                          <input type="text" class="form-control" name="mail" placeholder="Enter Remove Supplier E-Mail Address" id="input2" value="<%=list.get(2)%>">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Contact No</span>
                          </div>
                          <input type="text" class="form-control" name="contact" placeholder="Enter Remove Supplier Contact No" id="input2" value="<%=list.get(3)%>">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Items</span>
                          </div>
                          <input type="text" class="form-control" name="item" placeholder="Enter Remove Supplier Items" id="input2" value="<%=list.get(4)%>">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Reason</span>
                          </div>
                          <input type="text" class="form-control" name="reason" placeholder="Remove Reason" id="input2" pattern="[A-Za-z]{1,50}" title="Enter remove reason">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Date</span>
                          </div>
                          <input type="text" class="form-control" name="date" placeholder="Enter Supplier Remove Date" id="input2" pattern="[0-9]{2}+/[0-9]{2}+/[0-9]{4}" title="Enter remove date 01/01/2018">
                        </div>
                                <button type="submit" class="btn btn-outline-secondary" id="createbutton" name ="st" value="delete">Remove Supplier</button>
                                
                              </form>
                            </td>
                            </tr>
                            </table><br>
                            <%
								}
							}						
							else if (count == 0) {
						%>
							<tr>
							<td colspan=5 align="center"style="background-color:#F4F6F6"><b>No Record Found in database</b></td>
							</tr>
						<%    
							}
					%>
                </div>
              
        </div>
        
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
</body>
</html>