<!-- IT17024914 -->
<%@page import="org.eclipse.jdt.internal.compiler.codegen.ObjectCache"%>
<%@page import="java.io.ObjectStreamException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/mystyle.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="vendor/datatables/DataTables/css/dataTables.bootstrap4.min.css" />
    <link rel="stylesheet" href="vendor/datatables/Buttons/css/buttons.bootstrap4.min.css" />

    <link rel="stylesheet" href="css/bootstrap-datepicker.min.css" />

    <link rel="stylesheet" href="css/fonts.css">
    <script src="js/jQuery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/properjs.js"></script>
    <script src="js/bootstrao.awsom.font.js"></script>
    <script src="js/bootstrao.awsom.font.bundle.js"></script>
    <script src="js/jquery3.3.1.min.js"></script>
    <script src="js/bootstrap4.1.0.min.js"></script>
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
    <title>Activity Log</title>

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
                       <div class="row"><a href="profit.jsp" target="_self" class="link1"><i class="fas fa-dollar-sign"></i>&ensp;Profit & Lost</a></div>
                       <div class="row"><a href="Employee.jsp" target="_self" class="link1"><i class="fas fa-users"></i>&ensp;Employee</a></div>
                       <div class="row"><a href="FirstOrder.jsp" target="_self" class="link1"><i class="fas fa-truck"></i>&ensp;Order & Delivery</a></div>
                      <div class="row"><a href="index2.jsp" target="_self" class="link1"><i class="fas fa-clipboard-list"></i>&ensp;Bill</a></div>
                       <div class="row"><a href="Activity.jsp" target="_self" class="link2"><i class="fas fa-edit"></i>&ensp;Activity</a></div>
                       <div class="row"><a href="first.jsp" target="_self" class="link1"><i class="fas fa-dolly-flatbed"></i></i>&ensp;Supplire</a></div>
                </div>
            <div class="col-sm-10 ">
                <div class="container">
                    <!-- Page Heading/Breadcrumbs -->
                    <div class="row">
                        <div class="col-md-8">
                            <h1 class="mt-4 mb-3">
                                Activity
                                <small>Log</small>
                            </h1>
                        </div>
                        <div class="col-md-4" style="margin-top:20px;">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item">
                                    <a href="index.html">Home</a>
                                </li>
                                <li class="breadcrumb-item active">Activity List</li>
                            </ol>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">

                            <div class="card h-100">

                                <div class="card-body">
                                    <form class="form-inline"  action="viewAc" method="post">
                                        <label for="FromDate" class="mb-2 mr-sm-2">From Date:</label>
                                        <input type="text" class="form-control mb-2 mr-sm-5" id="FromDate" name="FromDate" placeholder="Select From Date">
                                        <label for="ToDate" class="mb-2 mr-sm-2">To Date:</label>
                                        <input type="text" class="form-control mb-2 mr-sm-5" id="ToDate" name="ToDate" placeholder="Select To Date">

                                        <div class="custom-control custom-checkbox mb-2 mr-sm-5">
                                            <input type="checkbox" class="custom-control-input" id="chkToday" name="chkToday" value="today">
                                            <label class="custom-control-label" for="chkToday">Today</label>
                                        </div>
                                        <div class="custom-control custom-checkbox mb-2 mr-sm-5">
                                            <input type="checkbox" class="custom-control-input" id="chkAll" name="chkAll" value="All">
                                            <label class="custom-control-label" for="chkAll">All</label>
                                        </div>
                                        <button type="submit" class="btn btn-primary mb-2">Filter</button>
                                        <div class="form-linebreak">
                                            <a href="#advOptions" class="btn btn-link" data-toggle="collapse">Advance Options</a>
                                            <div id="advOptions" class="collapse form-inline">
                                                <label for="user" class="mb-2 mr-sm-2">User:</label>
                                                <select class="form-control mb-2 mr-sm-5" id="user" name="user">
                                                    <option value="">All Users</option>
                                                    <option value="User1">Michelle De Silva</option>
                                                    <option value="User2">Nadun Sachintha</option>
                                                    <option value="User3">Dilruk Wijesooriya</option>
                                                    <option value="User4">Jagath De Almeida</option>
                                                    <option value="User5">Alex Fernando</option>
                                                    <option value="User6">Imesha Caldera</option>
                                                </select>
                                                <label for="Activity" class="mb-2 mr-sm-2">Activity:</label>
                                                <select class="form-control mb-2 mr-sm-5" id="Activity" name="Activity">
                                                    <option value="">All Activities</option>
                                                    <option value="act11">User Logged in to the system</option>
                                                    <option value="act12">User Logged out from the system</option>
                                                    <option value="act13">Create a record</option>
                                                    <option value="act14">Delete a record</option>
                                                </select>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="margin-top:20px;">
                        <table class="table table-striped table-bordered" id="Activities" option = "viewAc">
                        
                        <thead>
                                <tr>
                                    <th>Index</th>
                                    <th>Time Stamp</th>
                                    <th>User</th>
                                    <th>Activity</th>
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
                     %>  
                     
                     

                    <tr>
                        <td><b><%=search_list.get(0)%></b></td>
                
                        <td><b><%=search_list.get(1)%></b></td>
                   
                        <td><b><%=search_list.get(2)%></b></td>
                        
                        <td><b><%=search_list.get(3)%></b></td>
                      
                     </tr>

                    <%
                    			}
                			}						
        
                    %> 
                    
                    
                            
                       </tbody>
                           
                        </table>
                    </div>
                </div>

            </div>

        </div>

        <div class="row my-row2">
            <div class="col-lg-12 "><Footer>Weekend ITP Group 11 @ All Right recerved</Footer></div>
        </div>
    </div>
    <!--Data Tables-->

    <script src="vendor/datatables/DataTables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/DataTables/js/dataTables.bootstrap4.min.js"></script>
    <script src="vendor/datatables/Buttons/js/dataTables.buttons.min.js"></script>
    <script src="vendor/datatables/Buttons/js/buttons.bootstrap4.min.js"></script>

    <script src="vendor/datatables/JSZip-2.5.0/jszip.min.js"></script>
    <script src="vendor/datatables/pdfmake-0.1.36/pdfmake.min.js"></script>
    <script src="vendor/datatables/pdfmake-0.1.36/vfs_fonts.js"></script>
    <script src="vendor/datatables/Buttons/js/buttons.html5.min.js"></script>
    <script src="vendor/datatables/Buttons/js/buttons.print.min.js"></script>

    <!--Date Picker-->
    <script src="js/bootstrap-datepicker.min.js"></script>


    <script>
        $(function () {
            //Date picker
            $('#FromDate').datepicker({
                autoclose: true
            })
            $('#ToDate').datepicker({
                autoclose: true
            })

        });
        $(document).ready(function () {
            var table = $('#Activities').DataTable({
                buttons: ['copy', 'excel', 'pdf'],
                lengthChange: true

            });

            table.buttons().container()
                .appendTo('#Activities_wrapper .col-md-6:eq(0)');
        });

    </script>
</body>
</html>