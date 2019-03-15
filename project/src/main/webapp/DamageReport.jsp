<!-- IT16234062– Rajapakshe D.D.S -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.eclipse.jdt.internal.compiler.codegen.ObjectCache"%>
<%@page import="java.io.ObjectStreamException"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.util.dbConnect" %>
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 <%@ page import="com.model.user" %>   
<%
	Connection conn = null;
	
	Gson gsonObj = new Gson();
	Map<Object,Object> map = null;
	List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
	String dataPoints = null;
	try{
		
		conn = (Connection)dbConnect.conn();
		Statement sta = (Statement) conn.createStatement();
		String query1="Select name,amount from stockDamageitem where type='Damage-item'";
		ResultSet  rs = sta.executeQuery(query1);
		String xVal, yVal;
		while(rs.next()){
			xVal = rs.getString("name");
			yVal = rs.getString("amount");
			map = new HashMap<Object,Object>();
			map.put("label",xVal); 
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
    
    <title>Stock item Search</title>
    
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

			<script type="text/javascript">
						window.onload = function() { 
						 
						<% if(dataPoints != null) { %>
						var chart = new CanvasJS.Chart("chartContainer", {
							animationEnabled: true,
							exportEnabled: true,
							title: {
								text: "Stock Information"
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
                       <div class="row"><a href="StockItemManagement.jsp" target="_self" class="link2"><i class="fas fa-database"></i>&ensp;Storage</a></div>
                       <div class="row"><a href="profit.jsp" target="_self" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link1"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
        <div class="col-sm-10  my-col3 ">
        <br><br>
				<h3 align="center">Damage Column Chart Report</h1>
         <br><br>        
                <form action="reportButtonChart" method="post" align="center">
						<button type="submit" class="btn btn-btncolorbrown" name="st" Value="stock">Stock</button>
						<button type="submit" class="btn btn-btncolorPaple" name="st" Value="damage">Damage</button>
						<button type="submit" class="btn btn-primary" name="st" Value="nonStock">Non-Available</button>
						<button type="submit" class="btn btn-success" name="st" Value="return">Return</button>
						<button type="submit" class="btn btn-secondary" name="st" Value="repaired">Repaired</button>
						<button type="submit" class="btn btn-warning" name="st" Value="nonRepaired">Non-Repaired</button>
				</form> 
                 
                 <div id="chartContainer" style="height: 370px; width: 100%;"></div>
					<script src="resources/pie/js1.js"></script>
					<script src="resources/pie/js2.js"></script>
                    
                <form action="home" method="post">
						<button type="submit" class="btn btn-primary btn-block" name="st" Value="home">Home</button>
				</form>
		</div> 
	</div>
        
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
</div>
</body>
</html>