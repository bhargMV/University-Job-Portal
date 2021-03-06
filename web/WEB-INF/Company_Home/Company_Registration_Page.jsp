<%-- 
    Document   : Company_Registration_Page
    Created on : Mar 7, 2013, 12:16:41 AM
    Author     : V.BhargavaMourya
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Company Registration Page</title>
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
<h2><center><B>COMPANY REGISTRATION</B></center></h2>
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
<form action="Company_Registration_Verification" method="post" >
	<fieldset >
		<legend><h2><B>COMPANY DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0' bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>COMPANY NAME:</td>
				<td align="center"><input type="text" name="cname"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>TYPE OF ORGANIZATION:</td>
				<td >
                                    <% 
                                       String string= application.getInitParameter("Company Type");
                                       String[] Type= string.split(",");
                                    %>  
                                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="type" >
                                       
                                     <% for(int i=0;i<Type.length;i++)
                                       {
                                           out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<option value='"+Type[i]+"'>"+Type[i]+"</option>");
                                       }
                                     %>         
                                     </select>
                                </td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>INDUSTRY SECTOR:</td>
				<td >
                                    <% 
                                       String sector= application.getInitParameter("Industry Sector");
                                       String[] Sector= sector.split(",");
                                    %>  
                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="sector" >
                
                                     <% for(int i=0;i<Sector.length;i++)
                                       {
                                           out.println("<option value='"+Sector[i]+"'>"+Sector[i]+"</option>");
                                       }
                                     %>         
                                     </select>
                                </td>
			</tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>WEBSITE:</td>
				<td align="center"><input type="text" name="website"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>COMPANY LOCATION:</td>
				<td align="center"><input type="text" name="location"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>CTC:</td>
				<td align="center"><input type="text" name="ctc"></td>
			</tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>ELIGIBLE DEPARTMENTS:</td>
				<td >
                                    <% 
                                       String string1= application.getInitParameter("Departments");
                                       String[] Type1= string1.split(",");
                                    %>  
                                   
                                   <br/>
                                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                     <% for(int i=0;i<Type1.length;i++)
                                       {
                                           out.println("<input type='checkbox' name='departments' value='"+Type1[i]+"'>"+Type1[i]+"");
                                           if((i+1)%4==0)
                                           {
                                               out.println("&nbsp;&nbsp;<br/>");
                                               out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                           }
                                       }
                                        
                                     %>         
                                    
                                </td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>ELIGIBILITY CPI:</td>
				<td align="center"><input type="text" name="cpi"></td>
			</tr>
		</table>
	</fieldset><br>
	
	
	<fieldset>
		<legend><h2><B>CONTACT DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0' bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>NAME:</td>
				<td align="center"><input type="text" name="name"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>DESIGNATION:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;</td>
				<td align="center"><input type="text" name="designation"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>EMAIL:</td>
				<td align="center"><input type="text" name="email"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>MOBILE:</td>
				<td align="center"><input type="text" name="mobile"></td>
			</tr>
		</table>
	</fieldset><br>
	
	<fieldset>
		<legend><h2><B>CHOOSE USERNAME AND PASSWORD<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0'bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>LOGIN ID:</td>
				<td align="center"><input type="text" name="loginid"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>LOGIN PASSWORD:</td>
				<td align="center"><input type="password" name="password"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>CONFIRM PASSWORD:&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;</td>
				<td align="center"><input type="password" name="confpassword"></td>
			</tr>
		</table>
	</fieldset><br>
	
	<input type="submit" name="button" value="REGISTER" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
	<input type="submit" name="button" value="GOBACK" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
	
</form>

</body>
</html>