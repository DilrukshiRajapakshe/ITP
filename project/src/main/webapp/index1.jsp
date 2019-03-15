<!--IT17119122  Liyanage I.M  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.model.user" %>
     <%@ page import="java.util.*" %>
     <%@ page import="com.service.getDailyAttendance" %>
     <%@ page import="com.model.dailyAttendance" %>
     <%@ page import="com.util.dbConnect" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="java.util.*,java.sql.*" %>
	<%@ page import="com.google.gson.Gson"%>
	<%@ page import="com.google.gson.JsonObject"%>
	<%@ page import="com.service.getOrderDeatailsForDashboard" %>
	
     <%
	Connection conn = null;
	
	Gson gsonObj = new Gson();
	Map<Object,Object> map = null;
	List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
	String dataPoints = null;
	try{
		
		conn = (Connection)dbConnect.conn();
		Statement sta = (Statement) conn.createStatement();
		String query1 = "SELECT * FROM stockitem where type='Stock-item' and amount<=12";
		ResultSet  rs = sta.executeQuery(query1);
		String xVal, yVal;
		while(rs.next()){
			xVal = rs.getString("name");
			yVal = rs.getString("amount");
			map = new HashMap<Object,Object>();
			map.put("label", xVal); 
			map.put("y", Integer.parseInt(yVal)); 
			list.add(map);
			System.out.print(list);
			dataPoints = gsonObj.toJson(list);
		}
		conn.close();
	}catch(SQLException e){
		System.out.print(e);
	}	
%>
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


    <script src="resources/js/Chart/chart1.js"></script>
    <script src="resources/js/Chart/canvasjs.js"></script>
    <title>DashBoard</title>

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
                <div class="col-sm-6 my-col4">
                        <div class="col-sm-12 ">
             				<table>
             					<tr>
             						<td>
                               			<form action="getEmployee" method="post">
                               				<button type="submit" class="btn btn-primary btn-lg" id="createbutton">Mark Attendance</button>&ensp;&ensp;
                               			</form> 
                               		</td>
                               		<td>         
                         				<a href="attendance.jsp" target="_self"><button type="submit" class="btn btn-primary btn-lg" id="createbutton">View Attendance</button></a>
                         			</td>
                         		</tr>
                         	</table>
                         </div>
                         <br>
                               <script type="text/javascript">
						window.onload = function() { 
						 
						<% if(dataPoints != null) { %>
						var chart = new CanvasJS.Chart("chartContainer", {
							animationEnabled: true,
							exportEnabled: true,
							title: {
								text: "Less Available Items"
							},
							data: [{
								type: "column", //WE can change type to bar, line, area, pie, etc
								indexLabel: "{y}",
								indexLabelPlacement: "inside",
								dataPoints: <%out.print(dataPoints);%>
							}]
						});
						chart.render();
						<% } %> 
						 
						}
					</script>
					<div id="chartContainer" style="height: 370px; width: 100%;"></div>      
                        <div class="col-sm-12 my-col5">
                               <h2 style="text-align:center;padding-bottom:20px">Pending Orders</h2>
                        <table class="table table-striped">
                                        <thead>
                                          <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">order No</th>
                                            <th scope="col">Name</th>
                                          	<th scope="col">Address</th>
                                          	<th scope="col">Telephone</th>
                                          	<th scope="col">Status</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                        <%
             
                            	        getOrderDeatailsForDashboard GOD = new getOrderDeatailsForDashboard();
                            	        ArrayList al = GOD.getOrderDeatails();
                                        int Total = 0;
                                        int count = 0;
                                        
                                        if (al != null) {
                                            System.out.println(al);
                                            
                                            Iterator itr = al.iterator();
                                            while (itr.hasNext()) {          
                                                count++;
                                                ArrayList search_list = (ArrayList) itr.next();
                             			 %>
                                          <tr>
                                            <th scope="row"><%=count %></th>
                                            <td><%=search_list.get(0) %></td>
                                            <td><%=search_list.get(1) %></td>
                                            <td><%=search_list.get(2) %></td>
                                            <td><%=search_list.get(3) %></td>
                                            <td><%=search_list.get(4) %></td>
                                          </tr>
                                       	<%
                    						}
                						}						
                						if (count == 0) {
                    					%>
                    					<tr>
                        						<td colspan=6 align="center"style="background-color:#F4F6F6"><b>No pending order</b></td>
                    					</tr>
                    					<%    
                    					}
                						%>  
                                          
                                        </tbody>
                                      </table>
                                                      
                        </div>
                  
					
                        <!--  <div id="chartContainer" style="height: 370px; width: 100%;"></div>-->

                </div>
                <div class="col-sm-4 my-col4">
                        <h2 style="text-align:center;padding-bottom:20px">Daily Attendance</h2>
                        <table class="table table-striped">
                                        <thead>
                                          <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">In time</th>
                                          	<th scope="col">Out time</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                        dailyAttendance DA = new dailyAttendance();
                            	        DA.setDay();
                            	        DA.setMonth();
                            	        DA.setYear();
                            	        
                            	        getDailyAttendance GA = new getDailyAttendance();
                            	        ArrayList a2 = GA.getDailyAttendances(DA);
                                       
                                        int count1 = 0;
                                        
                                        if (a2 != null) {
                                            System.out.println(al);
                                            
                                            Iterator itr = a2.iterator();
                                            while (itr.hasNext()) {          
                                                count1++;
                                                ArrayList search_list = (ArrayList) itr.next();
                             			 %>
                                          <tr>
                                            <th scope="row"><%=count1 %></th>
                                            <td><%=search_list.get(0) %></td>
                                            <td><%=search_list.get(1) %></td>
                                            <td><%=search_list.get(2) %></td>
                                          </tr>
                                       	<%
                    						}
                						}						
                						if (count1 == 0) {
                    					%>
                    					<tr>
                        						<td colspan=6 align="center"style="background-color:#F4F6F6"><b>Attendance not marked yet</b></td>
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