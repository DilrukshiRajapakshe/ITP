<!--IT17159036– Attanayake A.M.O.M-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.model.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">  
	 <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/all.css">
    <link rel="stylesheet" href="resources/css/mystyle.css">
    <link rel="">
    <link rel="stylesheet" href="css/fonts.css">
    <script src="js/jQuery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/properjs.js"></script>
    <script src="js/bootstrao.awsom.font.js"></script>
    <script src="js/bootstrao.awsom.font.bundle.js"></script>
    <script src="js/jquery3.3.1.min.js"></script>
    <script src="js/bootstrap4.1.0.min.js"></script>
    
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
    <title>Cashier</title>
    <style>
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        #input1{
            width:100px;
        }
        #input2{
            width:200px;
            padding-right: 50px;
        }
        #table1 {
            border-collapse: collapse;
        }
    </style>
    	
    <script type = "Text/javascript">
    	
    		$(document).ready(function(){
    			$("#btnClick").click(function(){
    				var d = new Date();
    				var yr = d.getFullYear();
    				var mo = d.getMonth();
    				var hr = d.getHours();
    				var min = d.getMinutes();
    				var sec = d.getSeconds();
    				var f = {};
    				f.url = '@Url.Action("BIDgen","webapp")';
    				f.type = "POST";
    				f.dataType = "json";
    				f.data = JASON.stringify({yr :d.getFullYear() ,mo :d.getMonth(),hr :d.getHours(),min :d.getMinutes(),sec :d.getSeconds()});
    				f.success = function (response){
    					alert("success");
    				};
    				f.error = function (response){
    					alert("faild");
    				};
    				$.ajax(f);
    			});
    		});	
			
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
            <div class="col-sm-1  my-col2 ">
               <div class="row"></div>
            </div>
            <div class="col-sm-10  my-col3 ">
                <h2 class="text-center display-3">Cashier</h2>
		

                    <form class="input-group mb-3"  action="insert">
                           	<div>
                           		<input type= "radio" name = "emp2" id = "bill" value = "yess"  required>&ensp;New Bill<br/>
                            <br>
                            </div>
                        <div id = "disap" ><br>
                            <span class="input-group-text"  id="input1">Item code</span>
                            <span class="input-group-text"  id="input1">Item price</span>
                            <span class="input-group-text"  id="input1">Quantity</span>
                            <br>
                            <span class="input-group-text"  id="input1">Discount</span>
                        </div>
                        <div ><br>
                            <input type="text" name="ItemCode" class="form-control" placeholder="" id="input2" required>
                            <input type="text" name="ItemPrice" class="form-control" placeholder="" id="input2" required>
                            <input type="text" name="Qty" class="form-control" placeholder="" id="input2" required>
                            <br>
                            <input type="text" name="Disc" class="form-control" placeholder="" id="input2">
                            <br>
                            <button type="submit" class="btn btn-outline-secondary"  id="add" >ADD</button>
                        </div>
						<form action = "view">
                        <table>
                            <tr>
                                <th>Item Code</th>
                                <th style="width: 200px">Item Price</th>
                                <th>Quantity</th>
                                <th style="width: 200px">Net Price</th>
                            </tr>
                            <tr>
                                <td style="height: 300px"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>

                        </table>
                        <table>
                            <tr>
                                    <th style="height: 50px" width="100px">Total</th>
                                    <th width="300px"></th>
                            </tr>
                            <tr>
                                <th>Cash</th>
                                <th></th>
                            </tr>
                            <tr>
                                <th><button type="submit" class="btn btn-outline-secondary" id="createbutton">Ballance</button></th>
                                <th></th>
                            </tr>
                        </table>
						</form>
                    </form>
                    <div>
                    <br>
                    <button type="submit" class="btn btn-outline-secondary" id="createbutton"><a href="AdvanceOption.jsp">Advance Settings</a></button>
                    </div>
                    </div>
                    <div class="col-sm-1  my-col2 ">
               				<div class="row"></div>
            		</div>
                <br><br><br><br>
                </div>
                
                <div class="container">
                <div class="row my-row2">
                    <div class="col-lg-12 "><Footer >Weekend ITP Group 11 @ All Right recerved</Footer></div>
                </div>
                </div>
            </div>

      

</body>
</html>