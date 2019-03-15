<%@page import="java.io.ObjectStreamException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
	<%@ page import="com.model.employee" %>
	<%@ page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
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
    <title>Employee</title>
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
                       <div class="row"><a href="Employee.jsp" target="_self" class="link2"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  ha-co1 ">
                        <br>
                    <h1 style="text-align: center">Edit Employee</h1>
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
                    <form style="text-align:center"action="add" method="post">
                        <div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Employee ID</span>
                          </div>
                          <input type="text" class="form-control" name="id" placeholder="Enter New Employee ID" id="input2"value="<%=list.get(0)%>"pattern="[0-9]{1,3}" title="Three number employee id">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Full Name</span>
                          </div>
                          <input type="text" class="form-control" name="name" placeholder="Enter New Employee Name" id="input2"value="<%=list.get(1)%>"pattern="[A-Za-z]{1,50}" title="Enter employee name">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >NIC No</span>
                          </div>
                          <input type="text" class="form-control" name="nic" placeholder="Enter New Employee NIC No" id="input2"value="<%=list.get(2)%>"pattern="[a-zA-Z0-9]{10}" title="Enter employee NIC (xxxxxxxxxV)">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Occupation</span>
                          </div>
                          <input type="text" class="form-control" name="occupation" placeholder="Enter New Employee Occupation" id="input2"value="<%=list.get(3)%>"pattern="[A-Za-z]{1,50}" title="Enter employee occupation">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Salary</span>
                          </div>
                          <input type="text" class="form-control" name="salary" placeholder="Enter New Employee Salary" id="input2"value="<%=list.get(4)%>"pattern="[0-9]{1,20}" title="Enter employee Salary">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Birth Date</span>
                          </div>
                          <input type="text" class="form-control" name="bdate" placeholder="Enter New Employee Birth Date" id="input2"value="<%=list.get(5)%>"pattern="{1,50}" title="Enter employee birth dat">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Gender</span>
                          </div>
                          <input type="text" class="form-control" name="gender" placeholder="Enter New Employee Gender" id="input2"value="<%=list.get(6)%>"pattern="[A-Za-z]{1,50}" title="Enter employee Gender">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Contact No</span>
                          </div>
                          <input type="text" class="form-control" name="contact" placeholder="Enter New Employee Contact No" id="input2"value="<%=list.get(7)%>"pattern="[0-9]{10}" title="Enter employee contact no">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >E-Mail Address</span>
                          </div>
                          <input type="text" class="form-control" name="email" placeholder="Enter New Employee E-Mail" id="input2"value="<%=list.get(8)%>">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Home Address</span>
                          </div>
                          <input type="text" class="form-control" name="address" placeholder="Enter New Employee Home Address" id="input2"value="<%=list.get(9)%>"pattern="[A-Za-z]{1,50}" title="Enter employee address">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Nationality</span>
                          </div>
                          <input type="text" class="form-control" name="nationality" placeholder="Enter New Employee Nationality" id="input2"value="<%=list.get(10)%>"pattern="[A-Za-z]{1,50}" title="Enter employee nationality">
                        </div>
						<div class="input-group mb-3">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="input1" >Joined Date</span>
                          </div>
                          <input type="text" class="form-control" name="jdate" placeholder="Enter New Employee Joined Date" id="input2" value="<%=list.get(11)%>">
                        </div>
                                <button type="submit" class="btn btn-outline-secondary" id="createbutton"name ="st" value="Update">UPDATE</button>
                              </form>
                            </td>
                            </tr>
                            </table>
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