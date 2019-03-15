<!--IT17119122  Liyanage I.M  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.user" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/all.css">
    <link rel="stylesheet" href="resources/css/mystyle.css">
    
    <link rel="stylesheet" href="css/fonts.css">
    <script src="resources/js/jQuery.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/properjs.js"></script>
    <script src="resources/js/bootstrao.awsom.font.js"></script>
    <script src="resources/js/bootstrao.awsom.font.bundle.js"></script>
    <script src="resources/js/jquery3.3.1.min.js"></script>
    <script src="resources/js/bootstrap4.1.0.min.js"></script>
    <script src="resources/js/validation.js"></script>
    <title>Report</title>
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
            .t1{
                border:2px solid #F4F6F6;
                width: 100%;
                background: #F4F6F6;
                padding-top: 50px;
                
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
                       <div class="row"><a href="index1.jsp" target="_self" class="link2"><i class="fas fa-server"></i>&ensp; DashBoard</a></div>
                       <div class="row"><a href="user.jsp" target="_self" class="link1"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="StockItemManagement.jsp" target="_self" class="link1"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="profit.jsp" target="_self" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  my-col8 ">
                <table class="table">
                    <tr>
                        <td>
                        <div class="col-sm-12">
                            <h1 style="text-align:center">Attendance</h1>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="col-sm-12">
                                <form action="search4" method="POST" name="form3" onsubmit="return(validationReportSearch());">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" >Year</span>
                                        </div>
                                    <input type="text" class="form-control" placeholder="Enter year" id="input2" name="year">
                                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                    <div class="input-group-prepend">
                                            <span class="input-group-text" >Month</span>
                                        </div>
                                    <input type="text" class="form-control" placeholder="Enter month" id="input2" name="month">
                                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                    <div class="input-group-prepend">
                                            <span class="input-group-text" >Day</span>
                                        </div>
                                    <input type="text" class="form-control" placeholder="Enter day" id="input2" name="day">
                                    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                    <button type="submit" class="btn btn-outline-secondary" id="createbutton">Search</button>
                                    </div>
                                    
                                </form>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                         </td>
                    </tr>
                    <tr>
                    
                        <div class="col-sm-12 my-col7">
                   
                    	</div>
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