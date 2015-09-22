<%-- 
    Document   : Student_Registration_Page
    Created on : Mar 6, 2013, 11:08:45 PM
    Author     : V.BhargavaMourya
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Page</title>
        <!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
         
	table {
			margin: 0px;
			border-collapse: collapse;
			padding: 0px;
		}
                
                table.hovertable {
                    font-family: verdana,arial,sans-serif;
                    font-size:11px;
                    color:#333333;
                    border-width: 0px;
                    border-color: #999999;
                    border-collapse: collapse;
                }
                table.hovertable th {
                    background-color:#c3dde0;
                    border-width: 0px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #a9c6c9;
                }
                table.hovertable tr {
                    background-color:mistyrose;
                }
                table.hovertable td {
                    border-width: 0px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #a9c6c9;
                }
        </style>


</head>

<body>
<h2><center><B>STUDENT REGISTRATION</B></center></h2>
<%
    ArrayList err=(ArrayList)request.getAttribute("err");
    if(err!=null)
    {
    if(!err.isEmpty())
    {
        Iterator it=err.iterator();
        while(it.hasNext())
        {
            out.println(it.next()+"<br>");
        }
        
    }
    err.clear();
    }
%>
<form action="Student_Registration_Verification" method="post" >
	<fieldset >
		<legend><h2><B>COLLEGE DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0' bgcolor="mistyrose">
			
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>WEBMAIL ID:</td>
				<td align="center"><input type="text" name="webmail"></td>
			</tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>WEBMAIL PASSWORD: &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;</td>
				<td align="center"><input type="password" name="password"></td>
			</tr>
		</table>
	</fieldset><br>
	
	
	<fieldset>
		<legend><h2><B>PERSONAL DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0'  bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>GENDER:</td>
				<td >
                                    <% 
                                       String string= application.getInitParameter("Gender");
                                       String[] Type= string.split(",");
                                    %>  
                                   &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<select name="gender" >
                
                                     <% for(int i=0;i<Type.length;i++)
                                       {
                                           out.println("<option value='"+Type[i]+"'>"+Type[i]+"</option>");
                                       }
                                     %>         
                                     </select>
                                </td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>DOB:</td>
				<td align="center"><input type="text" name="dob"></td>
			</tr>
			
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>MOTHERS NAME:</td>
				<td align="center"><input type="text" name="mother"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>FATHERS NAME:</td>
				<td align="center"><input type="text" name="father"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>PRESENT ADDRESS:</td>
				<td><br><br>&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<textarea name="present"  rows="5" cols="25"></textarea></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>PERMANENT ADDRESS:</td>
				<td><br><br>&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<textarea name="permanent"  rows="5" cols="25"></textarea></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>EMAIL ID:</td>
				<td align="center"><input type="text" name="email"></td>
			</tr>
		</table>
	</fieldset><br>
	
	<fieldset>
		<legend><h2><B>ACADEMIC DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0' bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>10th %:</td>
				<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<input type="text" name="tenth"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>12th:</td>
				<td align="center">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<input type="text" name="twelth"></td>
			</tr>
      			
		</table>
	</fieldset><br>
	
		
	<input type="submit" name="button" value="REGISTER" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
	<input type="submit" name="button" value="GOBACK" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
        
</form>

</body>
</html>