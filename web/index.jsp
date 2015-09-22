<%-- 
    Document   : index
    Created on : Mar 6, 2013, 9:46:20 PM
    Author     : V.BhargavaMourya
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Common.MyDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
         
	table {
			margin: 0px;
			border-collapse: collapse;
			padding: 0px;
		}
        </style>
        
        <script type='text/javascript'>
            
                window.history.forward(1);function noBack() { window.history.forward(1); }
        </script>
        
</head>
<body onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>
<table style="height:100%;width:100%; position: absolute; top: 0; bottom: 0; left: 0; right: 0; float: left;" >
     <tr style="height: 13%; ">
        <td>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp <img src='header.gif'></td>
    </tr>
    <tr style="height: 87%; ">
        <td>
		<table style="height:87%;width:100%; position: absolute; top: 13%; bottom: 0; left: 0; right: 0; float: left; " border='0' >
			<td style="width:25%;" cellspacing="0" cellpadding="0">
				<table style="height:100%;width:25%; position: absolute; top: 0; bottom: 0; left: 0; right: 0; float: left; " border='0' >
				   <tr style="height:35%;width:25%;" bgcolor='yellow'>
				   <td cellspacing="0" cellpadding="0" valign="top">
                                       <h2><B>STATISTICS:</B></h2>
                                       <a href="Statistics" target="_blank"><h2>Placement Statistics</h2> </a>
                                   </td>
				   </tr>
				   <tr style="height:65%;width:25%;" bgcolor='aqua'>
				    <td cellspacing="0" cellpadding="0" valign="top"><h2><B>UPDATES:</B></h2>
                                    <%
                                        MyDB m=new MyDB();
                                        ArrayList arr=m.getUpdates();
                                        Iterator it=arr.iterator();
                                     %>
                                        <ul>
                                        <% while(it.hasNext())
                                        { %>
                                        <li><B> <% out.println(it.next()); %> </B></li>
                                        <% } %>
                                        </ul>
                                    </td>
				   </tr>
				</table>
			</td>
			<td style="width:75%;" cellspacing="0" cellpadding="0">
				<table style="height:100%;width:75%; position: absolute; top: 0; bottom: 0; left: 25%; right: 0; float: left;" border='0'>
					<tr style="height:50%;width:75%;" >
				    <td>
						<table style="height:50%;width:100%; position: absolute; top: 0; bottom: 0; left: 0; right: 0; float: left;" border='0' >
						<td style="width:60%;" cellspacing="0" cellpadding="0" bgcolor='mistyrose' valign="top" > 
                                                    <h2><B>ABOUT PLACEMENT CELL:</B> </h2>
                                                    <img align="left" src="placement.jpg">
                                                    &nbsp;The Training & Placement Cell handles all aspects of campus placements for the graduating students at IIT Guwahati. The T & P Cell is well equipped with excellent infrastructure to support each and every stage of the placement processes. The T & P staff members assist in arranging Pre-Placement Talks, Written Tests, Group Discussions, & Interviews etc. The Placement Cell also arrange interviews through video conferencing
                                                                                                   
						</td>
						<td style="width:40%;" cellspacing="0" cellpadding="0" bgcolor='greenyellow' valign="top">
                                                    
                                                    <fieldset>
								<legend><h2><B>LOGIN</B></h2></legend>
                                                                <% 
                                                                    
                                                                    ArrayList err = (ArrayList) request.getAttribute("err");

                                                                    if (err != null) {
                                                                        Iterator it1 = err.iterator();

                                                                        while (it1.hasNext()) {
                                                                            out.println(it1.next() + "<br>");
                                                                        }
                                                                        
                                                                        err.clear();
                                                                    }

                                                                %>
								<form action="Login_Verification" method="POST">
									USER ID:  &nbsp; &nbsp &nbsp &nbsp &nbsp <input type="text" name="uid"><br>
									USER TYPE:
												&nbsp &nbsp <select name="ltype">
												<option value="student">Student</option>
												<option value="pr">P.R</option>
												<option value="company">Company</option>
												<option value="admin">Admin</option>
												</select><br>
									PASSWORD:  &nbsp;    <input type="password" name="pwd"><br>
									  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="submit" name="login" onclick="parent.location.reload();" value="   LOGIN   " />
								</form>
							</fieldset><br>
							<form action="Registration_Page_Redirect" method="POST">
												<B><h2>REGISTER HERE:</h2></B>
												USER TYPE:<select name="rtype">
												<option value="student">Student</option>												
												<option value="company">Company</option>												
												</select>
												<input type="submit"  value="    REGISTER   " />
							</form>
						</td >
						</table>						
					</td>
				   </tr>
				   <tr style="height:50%;width:75%;" bgcolor='orange'>
				    <td valign="top">
                                        <h2><B>RULES & SCHEDULE:</B></h2>
                                        <a href="Policies and Regulations.pdf" target="_blank"><h2>Policies and Regulations</h2> </a>
                                        <a href="Schedule" target="_blank"><h2>Placement Schedule</h2> </a>
                                        <br><br>
                                        <h3 style="color:black">FOR ANY QUERIES ,CONTACT : <a href="mailto:placementsec@iitg.ernet.in" target="_blank">placementsec@iitg.ernet.in</a> </h3>
                                    </td>
				   </tr>
				</table>
			</td>
                        
		</table>
		</td>
    </tr>
    
    
</table>
                                                                
                   
                 
                    
</body>
</html>
