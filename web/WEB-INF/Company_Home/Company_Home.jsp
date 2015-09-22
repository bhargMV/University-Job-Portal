<%-- 
    Document   : Company_Home
    Created on : Mar 13, 2013, 1:30:42 AM
    Author     : V.BhargavaMourya
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
        
<script type='text/javascript'>
            
                window.history.forward(1);function noBack() { window.history.forward(1); }
        </script>
        
</head>
<body onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>
     <%
            response.setHeader("cache-control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %>
<table  style="height:100%;width:100%; position: absolute; top: 0; bottom: 0; left: 0; right: 0; float: left;"  border='0' cellspacing="0" cellpadding="0">
     <tr style="height: 10%;" bgcolor="yellow">
        <td>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp <img src='header3.gif'></td>
    </tr>
    <tr style="height: 90%; ">
        <td style="width= 15%;">
		<table  style="height:89%;width:13%; position: absolute; top: 11%; bottom: 0; left: 0; right: 0; float: left; " border='0' bgcolor="yellow">
		<form action="Company_Home_Process" method="POST">
			<tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="HOME"  style="background-color:yellowgreen; font-size:18; width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="SCHEDULE" style="background-color:yellowgreen;font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			
			<tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="APPLIED STUDENTS" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
                        <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="SELECTED STUDENTS" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
                        <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="UPLOAD JOB DETAILS" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="EDIT DETAILS" style="background-color:yellowgreen; font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                        <input TYPE="button" name="button" VALUE="PLACEMENT POLICIES" onclick="window.open('Policies and Regulations.pdf','_blank');"  style="background-color:yellowgreen; font-size:18;    width: 100%; height: 110%;"  Cellpadding='0'>
     			</td></tr>
			<tr><td style="width:13%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="LOG OUT" style="background-color:yellowgreen;  font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
		</form>	
		</table>
		</td>
		
		<td style="height:90%;width:87%; position: absolute; top: 10%; bottom: 0; left: 13%; right: 0; float: left; " border='0'>
                        
                    
                    
                    
                    <%
                      if(((String)request.getAttribute("click")).equals("HOME"))
                      {
                          out.println("<center><h1>Welcome     "+(String)session.getAttribute("loginid")+" !!</h1></center>");
                          
                            ArrayList err = (ArrayList) request.getAttribute("err");
                                if (err != null) {
                                    if (!err.isEmpty()) {
                                        Iterator it = err.iterator();
                                        while (it.hasNext()) {
                                             out.println("<center><h3>"+it.next() + "</h3></center>");
                                        }

                                    }
                                    err.clear();
                                }
                                
                           out.println("<center><h2><u>INSTRUCTIONS</u></h2></center>");
                    %>
                      
                       <ul>
                        <li><h3>HOME contains general instructions and Updates.</h3></li>
                        <li><h3>SCHEDULE has Placement Schedule.</h3></li>
                        <li><h3>APPLIED STUDENTS has list of Applied Students</h3></li>
                        <li><h3>SELECTED STUDENTS has list of Selected Students</h3></li>
                        <li><h3>You can edit your personal details in EDIT DETAILS section.</h3></li>                        
                        <li><h3>You can view all the rules and regulations of placement call under PLACEMENT POLICIES</h3></li>
                        <li><h3>Hit LOG OUT to end your session</h3></li>
                    </ul>
                      <%
                      }
                    %>
                    

                    <%
                      if(((String)request.getAttribute("click")).equals("SCHEDULE"))
                      { ArrayList[] Schedule=(ArrayList[])request.getAttribute("Schedule");
                          out.println("<center><h1>SCHEDULE</h1></center>"); %>
                          
                     
                       <table class="hovertable" style="width:90%; position: absolute; top: 13%; bottom: 0; left: 5%; right: 5%; float: left; " border="1">
                       <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <th>COMPANY</th>
                           <th>SECTOR </th>
                           <th>WRITTEN TEST</th>
                           <th>TIME SLOT</th>
                           <th>VENUE</th>
                           <th>DAY</th>
                           
                        </tr>
                        
                        <%
                         Iterator it1=Schedule[0].iterator();
                         Iterator it2=Schedule[1].iterator();
                         Iterator it3=Schedule[2].iterator();
                         Iterator it4=Schedule[3].iterator();
                         Iterator it5=Schedule[4].iterator();
                         Iterator it6=Schedule[5].iterator();
                         
                         
                         while(it1.hasNext())
                         { %>
                            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <% out.println("<td align='center'>"+it1.next()+"</td>");
                             out.println("<td align='center'>"+it2.next()+"</td>");
                             out.println("<td align='center'>"+it3.next()+"</td>");
                             out.println("<td align='center'>"+it4.next()+"</td>");
                             out.println("<td align='center'>"+it5.next()+"</td>");
                             out.println("<td align='center'>"+(Integer)it6.next()+"</td>");
                             
                             out.println("</tr>");
                         }
                         
                         
                        %>
                       </table>
                     <% } 
                    %>
                    
                    
                    
                    
                    
                    <%
                      if(((String)request.getAttribute("click")).equals("SELECTED STUDENTS"))
                      { ArrayList[] SelectedStudents=(ArrayList[])request.getAttribute("SelectedStudents");
                          out.println("<center><h1>SELECTED STUDENTS</h1></center>"); %>
                          
                     
                       <table class="hovertable" style="width:90%; position: absolute; top: 13%; bottom: 0; left: 5%; right: 5%; float: left; " border="1">
                       <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <th>ROLL</th>
                           <th>NAME </th>
                           <th>WEBMAIL</th>
                           <th>PROGRAMME</th>
                           <th>DEPARTMENT</th>
                           
                           
                        </tr>
                        
                        <%
                         Iterator it1=SelectedStudents[0].iterator();
                         Iterator it2=SelectedStudents[1].iterator();
                         Iterator it3=SelectedStudents[2].iterator();
                         Iterator it4=SelectedStudents[3].iterator();
                         Iterator it5=SelectedStudents[4].iterator();
                         
                         
                         
                         while(it1.hasNext())
                         { 
                        %>
                            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">                           
                         <%  out.println("<td align='center'>"+it1.next()+"</td>");
                             out.println("<td align='center'>"+it2.next()+"</td>");
                             out.println("<td align='center'>"+it3.next()+"</td>");
                             out.println("<td align='center'>"+it4.next()+"</td>");
                             out.println("<td align='center'>"+it5.next()+"</td>");
                             
                             
                             out.println("</tr>");
                         }
                         
                         
                        %>
                       </table>
                     <% } 
                    %>
                    
                    
                    
                    
                    <%
                      if(((String)request.getAttribute("click")).equals("APPLIED STUDENTS"))
                      { ArrayList[] AppliedStudents=(ArrayList[])request.getAttribute("AppliedStudents");
                      String filePath = application.getInitParameter("stud-file-upload");
                          out.println("<center><h1>APPLIED STUDENTS</h1></center>"); %>
                          
                     <form action="Company_Home_Process" method="POST" > 
                       <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <th>SELECT</th>
                           <th>ROLL NO </th>                           
                           <th>NAME </th>
                           <th>WEBMAIL</th>
                           <th>PROGRAMME</th>
                           <th>DEPARTMENT</th>
                           <th>CPI</th>
                           <th>GENDER</th>
                           <th>DATE OF BIRTH</th>
                           <th>PRESENT ADDRESS</th>                           
                           <th>EMAIL</th>
                           <th>10th %</th>
                           <th>12th %</th>
                           <th>CV</th>
                      </tr>
                        
                        <%
                         Iterator it11= AppliedStudents[0].iterator();
                         Iterator it12=AppliedStudents[1].iterator();
                         Iterator it13=AppliedStudents[2].iterator();
                         Iterator it14=AppliedStudents[3].iterator();
                         Iterator it15=AppliedStudents[4].iterator();
                         Iterator it16=AppliedStudents[5].iterator();
                         Iterator it17=AppliedStudents[6].iterator();
                         Iterator it18=AppliedStudents[7].iterator();
                         Iterator it19=AppliedStudents[8].iterator();
                         Iterator it20=AppliedStudents[9].iterator();
                         Iterator it21=AppliedStudents[10].iterator();
                         Iterator it22=AppliedStudents[11].iterator();
                         Iterator it23=AppliedStudents[12].iterator();
                         while(it11.hasNext())
                         {
                             int rno=(Integer)it11.next();
                            %> 
                           <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <%
                             out.println("<td align='center'><input type='checkbox' name='checkbox' value='"+rno+"'></td> ");
                             out.println("<td align='center'>"+rno+"</td>");
                             out.println("<td align='center'>"+it12.next()+"</td>");
                             out.println("<td align='center'>"+it13.next()+"</td>");
                             out.println("<td align='center'>"+it14.next()+"</td>");
                             out.println("<td align='center'>"+it15.next()+"</td>");
                             out.println("<td align='center'>"+it16.next()+"</td>");
                             out.println("<td align='center'>"+it17.next()+"</td>");
                             out.println("<td align='center'>"+it18.next()+"</td>");
                             out.println("<td align='center'>"+it19.next()+"</td>");
                             out.println("<td align='center'>"+it20.next()+"</td>");
                             out.println("<td align='center'>"+it21.next()+"</td>");
                             out.println("<td align='center'>"+it22.next()+"</td>");
                             %>
                              
                                 <% String link=(String)it23.next();
                                 if(!link.equals("-")){ %>
                                    <td align="center"> <a href='<%=filePath+rno+"\\"+link%>' target="_blank" >click</a> </td>                                   
                                    <%}
                                    else{ %>
                                    <td align="center">---- </td>
                                    
                                  <%  }
                             out.println("</tr>");
                         }                         
                         
                        %>
                      
                       </table>
                       
                        <center> <input type="submit" name="upload" value="SELECT" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" > </center>
                      </form>
                       
                     <% } 
                    %>
                  
                    
                    <%
                 if(((String)request.getAttribute("click")).equals("UPLOAD JOB DETAILS"))
                 { %>
                 <table class="hovertable" style="width:95%; position: absolute; top: 13%; bottom: 0; left: 0; right: 5%; float: left; " border="0">
                     <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';"><td><fieldset>
                     <legend>UPLOAD JOB DETAILS</legend> 
                     <form action="Upload_Company_Details" method="POST" enctype="multipart/form-data">
                     UPLOAD JOB DETAILS:
                     <input type="file" name="details" ><br>
                     
                     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="submit" name="upload" value="UPLOAD" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
                     </form>
                 </fieldset></td></tr>
                  
                 </table>
                 <%} %>
                    
                 
	</td>
    </tr>
	
	
</table>
</body>
</html>