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
      #search1{
        width: 100px;
        height:45px;
    }
    #search2{
        width:930px;
        height:45px;
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
                        <div class="col-sm-12 my-col6">
                                <a href="newUser.jsp" target="_self"><button type="submit" class="btn btn-success btn-lg" id="createbutton">Create</button></a>&ensp;&ensp;&ensp;&ensp;
                                <a href="report.jsp" target="_self"><button type="submit" class="btn btn-primary btn-lg" id="createbutton">Get Report</button></a>
                        </div>
                        <div class="input-group mb-3">
                         <form action="search1" method="post" name="form44" onsubmit="return(validationSearch2());">
                                        <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="search1" >Search user</span>
                                                </div>
                                            <input type="text" class="form-control" name="search" placeholder="Enter New Uer Name" id="search2">&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                            <button type="submit" class="btn btn-outline-secondary" id="createbutton" >Search</button>
                                        </div>
                                        
                           </form>
                            </div>
                        <div class="col-sm-12 my-col7">
                                <table class="table table-striped">
                                        <thead>
                                          <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">User Id</th>
                                            <th scope="col">User Name</th>
                                            <th scope="col">Password</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Type</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                     <%
                                        int Total = 0;
                                        int count = 0;
                                        
                                        if (request.getAttribute("result") != null) {
                                            ArrayList al = (ArrayList) request.getAttribute("result");
                                            System.out.println(al);
                                            
                                            Iterator itr = al.iterator();
                                            while (itr.hasNext()) {          
                                                count++;
                                                ArrayList search_list = (ArrayList) itr.next();
                                     %><form action="deleteupdate" method="post">
                                          <tr>
                                          	<th scope="row"><%=count %></th>
                                          	<td><input type="hidden" name="uid" value="<%=search_list.get(0)%>"><%=search_list.get(0) %></td>
                                            <td><input type="hidden" name="uname" value="<%=search_list.get(1)%>"><%=search_list.get(1) %></td>
                							<td><input type="hidden" name="password" value="<%=search_list.get(2)%>"><%=search_list.get(2)%></td>
               	 							<td><input type="hidden" name="email" value="<%=search_list.get(3)%>"><%=search_list.get(3)%></td>
               	 							<td><input type="hidden" name="type" value="<%=search_list.get(4) %>"><%=search_list.get(4) %></td>
               	 	
              	  							<td>
              	  									<button type="Submit" class="btn btn-info" name="ud" value="update">Update</button>
                							</td>
                							<td>
                									<button type="submit" class="btn btn-danger"  name="ud" value="delete">Delete</button>
													<input type="hidden" name="dsearch" value="<% %>">
                							</td>
                                          </tr>
                                         </form>
                                       <%
                    						}
                						}						
                						if (count == 0) {
                    					%>
                    						<tr>
                        						<td colspan=6 align="center"style="background-color:#F4F6F6"><b>No Record Found..</b></td>
                    						</tr>
                    					<%    
                    					}
                						%>
                                        </tbody>
                                      </table>
                                      
                        </div>
                </div>
              
        </div>
        
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
</body>
</html>