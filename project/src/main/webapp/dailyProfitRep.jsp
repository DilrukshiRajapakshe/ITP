<!--IT17089296– Hapuarachchi H.D.H.U-->
<%@page import="org.eclipse.jdt.internal.compiler.codegen.ObjectCache"%>
<%@page import="java.io.ObjectStreamException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/all.css">
    <link rel="stylesheet" href="resources/css/mycss.css">
    <link rel="stylesheet" href="resources/css/mystyle.css">
    
    <link rel="stylesheet" href="resources/css/fonts.css">
    <script src="resources/js/jQuery.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/properjs.js"></script>
    <script src="resources/js/bootstrao.awsom.font.js"></script>
    <script src="resources/js/bootstrao.awsom.font.bundle.js"></script>
    <script src="resources/js/jquery3.3.1.min.js"></script>
    <script src="resources/js/bootstrap4.1.0.min.js"></script>
    <title>Profit & Lost</title>
    <style>
        .table{
             border:2px solid #9fa8a3;
       		 width: 90%;
        }
        .tab1{
			table-layout:fixed;
            text-align: left;
            
            border:2px solid #9fa8a3;
            width: 100%;
            background-color:rgb(250, 250, 250);      
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
                <div class="col-sm-2  my-col2 ">
                       <div class="row"><a href="index1.jsp" target="_self" class="link1"><i class="fas fa-server"></i>&ensp; DashBoard</a></div>
                       <div class="row"><a href="user.jsp" target="_self" class="link1"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="StockItemManagement.jsp" target="_self" class="link1"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="profit.jsp" target="_self" class="link2"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
              
              <div class="col-sm-10 mc1">
                    <br>
                        <h1 style="text-align: center">Profit & Lost</h1>
                    <br>
                   
                    <div class="col-sm-12 my-col7">
                                <table class="table table-striped">
                                        <thead>
                                          <tr>
                                           	<th scope="col">View ID</th>
                                           	<th scope="col">Date</th>
                                            <th scope="col">Item Number</th>
                                            <th scope="col">Item Name</th>
                                            <th scope="col">sold Quantity</th>
                                            <th scope="col">Profit</th>
                                            
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
                                                ArrayList list = (ArrayList) itr.next();
                     %>
                     <form action="deleteData" method="post">  

                    <tr>
                    	<th scope="row"><%=count %></th>
                        <td><input type="hidden" name="Date" value="<%=list.get(0)%>"><%=list.get(0)%></td>
                
                        <td><input type="hidden" name="ItemNo" value="<%=list.get(1)%>"><%=list.get(1)%></td>
                   
                        <td><input type="hidden" name="itemName" value="<%=list.get(2)%>"><%=list.get(2)%></td>
                         <td><input type="hidden" name="qty" value="<%=list.get(3)%>"><%=list.get(3)%></td>
                         <td><input type="hidden" name="profit" value="<%=list.get(4)%>"><%=list.get(4)%></td>
                        
                      
                     </tr>
                    </form>
                    <%
                    			}
                			}
                                        else if (count == 0) {
                                        %>
                                        <tr>
											<td colspan=5 align="center"style="background-color:#F4F6F6"><b>No Record Found in database</b></td>
										</tr>
                                   </tbody>
                                   </table>
                       <%
                    			}
         	            %>                   
        
                   
                </div>
               
          </div>
     </div>
   <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
    
</body>
</html>