
<%@page import="java.io.ObjectStreamException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
	<%@ page import="com.model.employee" %>
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
    
    <title>employee</title>
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
        
            <div class="col-sm-10 "><h1 class="banner"><i class="fas fa-screwdriver"></i>Shakthi <i class="fas fa-gavel"></i> Hardware<i class="fas fa-shipping-fast"></i></h1></div>
            <div class="col-sm-2 my-logout">
                    <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="button1">
                                    <i class="fas fa-user"></i>
                            </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#" class="dropdown-logout"><i class="fas fa-user"></i>&ensp;User Profile</a>
                                    <a class="dropdown-item" href="logOut" class="dropdown-logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</a>
                                </div>
                                <br>
                                
                    </div>
            </div>
        </div>
        <div class="row my-row6">
                <div class="col-sm-2  my-col2 ">
                       <div class="row"><a href="index1.jsp" target="_self" class="link1"><i class="fas fa-server"></i>&ensp; DashBoard</a></div>
                       <div class="row"><a href="user.jsp" target="_self" class="link1"><i class="fas fa-user"></i>&ensp;User</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link2"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;View Reports</a></div>
                       <div class="row"><a href="default.asp" target="_blank" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="default.asp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
                <div class="col-sm-10  my-col3 ">
                        <br>
                        <table class="table table-striped">
                        <thead>
						<tr>
						<th scope="col"></th>
						  <th scope="col">Employee ID</th>
						  <th scope="col">Name</th>
						  <th scope="col">NIC</th>
						  <th scope="col">Gender</th>
						  <th scope="col">Birth Date</th>
						  <th scope="col">Nationality</th>
						  <th scope="col">Occupation</th>
						  <th scope="col">Salary</th>
						  <th scope="col">Contact No</th>
						  <th scope="col">Email</th>
						  <th scope="col">Address</th>
						  <th scope="col">Join Date</th> 
						  <th scope="col"></th>
						  <th scope="col"></th>
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
									ArrayList list = (ArrayList)itr.next();
                        %>
	                        <form action="readTable" method="post">
								<tr>
								  <th scope="row"><%=count %></th>
								  <td><input type="hidden" name="Id" value="<%=list.get(0)%>"><%=list.get(0) %></td>
								  <td><input type="hidden" name="name" value="<%=list.get(1)%>"><%=list.get(1) %></td>
								  <td><input type="hidden" name="nic" value="<%=list.get(2)%>"><%=list.get(2) %></td>
								  <td><input type="hidden" name="gender" value="<%=list.get(3)%>"><%=list.get(3) %></td>
								  <td><input type="hidden" name="bdate" value="<%=list.get(4)%>"><%=list.get(4) %></td>
								  <td><input type="hidden" name="nationality" value="<%=list.get(5)%>"><%=list.get(5) %></td>
								  <td><input type="hidden" name="occupation" value="<%=list.get(6)%>"><%=list.get(6) %></td>
								  <td><input type="hidden" name="salary" value="<%=list.get(7)%>"><%=list.get(7) %></td>
								  <td><input type="hidden" name="contact" value="<%=list.get(8)%>"><%=list.get(8) %></td>
								  <td><input type="hidden" name="email" value="<%=list.get(9)%>"><%=list.get(9) %></td>
								  <td><input type="hidden" name="address" value="<%=list.get(10)%>"><%=list.get(10) %></td>
								  <td><input type="hidden" name="jdate" value="<%=list.get(11)%>"><%=list.get(11) %></td>
								  <td><button type="Update" class="btn btn-btncolorPaple" id="createbutton" name="st" Value="Update">Update</button>
								  	<input type="hidden" name="Id" value="<%=list.get(0)%>">
								  </td>
								  <td><button type="Delete" class="btn btn-btncolorbrown" id="createbutton" name="st" Value="Delete">Deleted</button>
								  	<input type="hidden" name="Id" value="<%=list.get(0)%>">
								  </td>
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
						<%    
							}
						%>
					  </tbody>
					</table>
					</div>
                
              
        </div>
        
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
</body>
</html>