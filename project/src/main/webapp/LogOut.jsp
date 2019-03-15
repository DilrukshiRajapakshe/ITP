<!--IT17119122  Liyanage I.M  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>Logout</title>
    
    <SCRIPT type="text/javascript">
		function noBack() { 
   			window.history.forward(); 
  		 }
</SCRIPT>
	
</head>
<body onload="noBack();">
    <div class="contaianer">
        <div class="row my-row1">
            <div class="col-sm-12"><h1 class="banner"><i class="fas fa-screwdriver"></i>Shakthi <i class="fas fa-gavel"></i> Hardware<i class="fas fa-shipping-fast"></i></h1></div>
            
        </div>
        <div class="row my-row7">
            <div class="col-sm-4 my-col8">
             
            </div>
            <div class="col-sm-4 my-col9">
                    <h1 class="para1"><i class="fas fa-user"></i><h2>log in</h2></h1>
                   			
                   			<form action="login" method="post" name="form1" onsubmit="return(validationLogin());">
                        
                                <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                                <span class="input-group-text" id="input3" >User Name</span>
                                        </div>
                                <input type="text" class="form-control" placeholder="User" name="uName" id="input2">
                                </div>
                                <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                                <span class="input-group-text" id="input3" >Password</span>
                                        </div>
                                <input type="password" class="form-control" placeholder="password" name="password" id="input2">
                                </div><br>
                               
                                <button type="submit" class="btn btn-primary" id="loggingbutton">Login</button>
                         	</form>
                         	<br>
                         	<br>
                         	<div  class="alert alert-info">
                         		<%String e = (String)request.getAttribute("result");%>
  								<strong><%=e%></strong>
  							</div>
							
            </div> 
            <div class="col-sm-4 my-col8">
            		
			</div>   
        </div>
  
        </div>
        <div class="row my-row2">
                <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
</body>
</html>