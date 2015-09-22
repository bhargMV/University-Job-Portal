<%-- 
    Document   : Company_Update_Details
    Created on : Mar 29, 2013, 11:21:08 PM
    Author     : V.BhargavaMourya
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Update Details Page</title>
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
                    border-width: 1px;
                    border-color: #999999;
                    border-collapse: collapse;
                }
                table.hovertable th {
                    background-color:#c3dde0;
                    border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #a9c6c9;
                }
                table.hovertable tr {
                    background-color:mistyrose;
                }
                table.hovertable td {
                    border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #a9c6c9;
                }
        </style>
</head>

<body>
<h1><center><B>UPDATE DETAILS</B></center></h1>
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

<%
    ArrayList RegisteredCompanytInfoForUpdating=(ArrayList)request.getAttribute("RegisteredCompanyInfoForUpdating");
    Iterator it=RegisteredCompanytInfoForUpdating.iterator();
%>

<form action="Company_Update_Verification" method="post" >
	<fieldset >
		<legend><h2><B>COMPANY DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0' bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>COMPANY NAME:</td>
                                <td align="center"><input type="text" name="cname" value="<%=it.next() %>" readonly></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>TYPE OF ORGANIZATION:</td>
				<td align="center" > <input type="text" name="type" value="<%=it.next() %>" readonly></td>
                                   
                                
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>INDUSTRY SECTOR:</td>
				<td align="center"> <input type="text" name="sector" value="<%=it.next() %>" readonly></td>                              
                                
			</tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>WEBSITE:</td>
				<td align="center"><input type="text" name="website" value="<%=it.next() %>"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>COMPANY LOCATION:</td>
				<td align="center"><input type="text" name="location" value="<%=it.next() %>"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>CTC:</td>
				<td align="center"><input type="text" name="ctc" value="<%=it.next() %>"></td>
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
                                     <% 
                                       
                                       String temp=(String)it.next();
                                       String[] temp1=temp.split(",");
                                       int j=0;
                                       
                                       for(int i=0;i<Type1.length;i++)
                                       {   
                                           if(j<temp1.length && Type1[i].equals(temp1[j]))
                                           {
                                                out.println("<input type='checkbox' name='departments' value='" + Type1[i] + "' checked >" + Type1[i] + "");
                                               if ((i + 1) % 4 == 0) {
                                                   out.println("&nbsp;&nbsp;<br/>");
                                                   out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                               }
                                               j++;
                                           
                                           }
                                           
                                           else
                                           {
                                               out.println("<input type='checkbox' name='departments' value='" + Type1[i] + "' >" + Type1[i] + "");
                                               if ((i + 1) % 4 == 0) {
                                                   out.println("&nbsp;&nbsp;<br/>");
                                                   out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                               }
                                               
                                           }
                                       }
                                        
                                     %>         
                                    
                                </td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>ELIGIBILITY CPI:</td>
				<td align="center"><input type="text" name="cpi" value="<%=it.next() %>"></td>
			</tr>
		</table>
	</fieldset><br>
	
	
	<fieldset>
		<legend><h2><B>CONTACT DETAILS<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0' bgcolor="mistyrose">
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>NAME:</td>
				<td align="center"><input type="text" name="name" value="<%=it.next() %>" size="29"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>DESIGNATION:  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;</td>
				<td align="center"><input type="text" name="designation" value="<%=it.next() %>" size="29"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>EMAIL:</td>
				<td align="center"><input type="text" name="email" value="<%=it.next() %>" size="29"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>MOBILE:</td>
				<td align="center"><input type="text" name="mobile" value="<%=it.next() %>" size="29"></td>
			</tr>
		</table>
	</fieldset><br>
	
	<fieldset>
		<legend><h2><B>UPDATE PASSWORD<B></h2></legend>
		<table class="hovertable" border='0' cellspacing='0' cellpadding='0'bgcolor="mistyrose">
			
                        
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>LOGIN ID:</td>
				<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="loginid" value="<%=it.next() %>" readonly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
                        
                        <input type="hidden" name="pwd" value="<%= (String)it.next() %>" />
                        
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>OLD PASSWORD:</td>
				<td align="center">&nbsp;<input type="password" name="oldpassword"></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
				<td>NEW PASSWORD:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;</td>
				<td align="center"><input type="password" name="newpassword"></td>
			</tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <td>Change Password</td>
                                
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='change' value="change" ></td>
                        </tr>
		</table>
	</fieldset><br>
	
	
	<input type="submit" name="button" value="UPDATE" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
	<input type="submit" name="button" value="GOBACK" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
</form>

</body>
</html>
