<!--IT17119122  Liyanage I.M  -->
<%@page import="org.eclipse.jdt.internal.compiler.codegen.ObjectCache"%>
<%@page import="java.io.ObjectStreamException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
    <script src="resources/js/validation.js"></script>
    <title>User</title>
    <style>
    #createbutton{
        width: 150px;
    }
    #input1{
        width:200px;
        background-color: aliceblue;
        color:black;
    }
    .input2{
        width:400px;
        padding-right: 50px;
    }
    input[type=text]{
        width:200px;
    }
    .table{
        border:2px solid #F4F6F6;
        width: 100%;
        background: #F4F6F6;
        padding-top: 20px;
        
    }
    </style>
</head>
<body>
    <div class="contaianer">
        <div class="row my-row1">
        <% user currentUser = (user)(session.getAttribute("currentSessionUser"));%>
            <div class="col-sm-10 "><h1 class="banner"><i class="fas fa-screwdriver"></i>Shakthi <i class="fas fa-gavel"></i> Hardware<i class="fas fa-shipping-fast"></i></h1></div>
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
                       <div class="row"><a href="user.jsp" target="_self" class="link2"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="StockItemManagement.jsp" target="_self" class="link1"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="profit.jsp" target="_self" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  my-col3 ">
                        <br>
                    <table class="table">
                        <tr>
                            <td>
                                <h1 style="text-align: center">Update user</h1>
                            </td>
                        </tr>
                         <%
                                        int Total = 0;
                                        int count = 0;
                                        
                                        if (request.getAttribute("result") != null) {
                                            ArrayList al = (ArrayList) request.getAttribute("result");
                                            System.out.println(al);
                         %>
                        <tr>
                            <td>
                                <form style="text-align:center" action="update1" method="POST" name="form2" onsubmit="return(validationUserRegistrstion());">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="input1" >User Id</span>
                                        </div>
                                    <input type="text" class="form-control" name="uid" Value="<%=al.get(0)%>" id="input2">
                                    </div>
                      
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"  id="input1">User name</span>
                                        </div>
                                    <input type="text" class="form-control" name="uName" Value="<%=al.get(1)%>" id="input2">
                                    </div>
                          
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="input1">password</span>
                                        </div>
                                    <input type="text" class="form-control" name="password" Value="<%=al.get(2)%>" id="input2">
                                    </div>

                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                          <span class="input-group-text" id="input1">Email</span>
                                        </div>
                                        <input type="email" class="form-control" name="email"  Value="<%=al.get(3)%>" id="input2">
                                    </div>

                                    <div class="form-check" style="text-align:left">
                                        <label class="form-check-label">
                                       
                                           &emsp;&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;  &ensp;
                                           <% if(al.get(4).equals("User")){%>
                                           		<input type="radio" class="form-check-input" name="type" value="User" checked>User&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                           		<input type="radio" class="form-check-input" name="type" value="Admin">Admin
                                           <% }else if(al.get(4).equals("Admin")){%>
                                           		<input type="radio" class="form-check-input" name="type" value="User" >User&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                           		<input type="radio" class="form-check-input" name="type" value="Admin" checked>Admin
                                          <% }%>
                                           
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-outline-secondary" id="createbutton">Update</button>
                                    <input type="hidden" name="dsearch" value="<% %>">
                              </form>
                              <%
                    				
                				}						
                						
                    			%>
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