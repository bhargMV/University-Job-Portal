<%-- 
    Document   : Stud_Home
    Created on : Mar 7, 2013, 12:24:09 AM
    Author     : V.BhargavaMourya
--%>

<%@page import="Common.MyDB"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
	<style type="text/css">
         
            table {
                margin: 0px;
                border-collapse: collapse;
                padding: 0px;
            }

            .LinkButton {
                display: block;
                width: 100%;
                height:100%;
                
                background: yellowgreen;
                text-align: center;
               text-decoration: none;
              padding:0;
              alignment-adjust: 30px;
                color: black;
               
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
        <td style="width: 14%;">
		<table style="height:89%;width:14%; position: absolute; top: 11%; bottom: 0; left: 0; right: 0; float: left; " border='0' bgcolor="yellow">
		<form action="Student_Home_Process" method="POST">
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="HOME"  style="background-color:yellowgreen; font-size:18; width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="SCHEDULE" style="background-color:yellowgreen;font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="COMPANIES" style=" background-color:yellowgreen; font-size:18;    width: 100%; height: 110%;" Cellpadding='0' >
			</td></tr>			
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="APPLY" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
                        <tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="COMPANIES APPLIED" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="EDIT DETAILS" style="background-color:yellowgreen; font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="UPLOAD CV" style="background-color:yellowgreen;    font-size:18;  width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
                        <input TYPE="button" name="button" VALUE="PLACEMENT POLICIES" onclick="window.open('Policies and Regulations.pdf','_blank');"  style="background-color:yellowgreen; font-size:18;    width: 100%; height: 110%;"  Cellpadding='0'>
     			</td></tr>
			<tr><td style="width:14%;" cellspacing="0" cellpadding="0">
			<input type="submit" name="button" value="LOG OUT" style="background-color:yellowgreen;  font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
			</td></tr>
		</form>	
		</table>
	</td>
		
	<td style="height:90%;width:84%; position: absolute; top: 10%; bottom: 0; left: 16%; right: 0; float: left; " border='0'>

                    
            
                    <%
                      if(((String)request.getAttribute("click")).equals("HOME"))
                      {
                          out.println("<center><h1>Welcome     "+(String)session.getAttribute("webmail")+" !!</h1></center>");
                          
                          ArrayList err = (ArrayList) request.getAttribute("err");
                          String error="";
                           if (err != null) {
                                    if (!err.isEmpty()) {
                                        Iterator it = err.iterator();
                                        while (it.hasNext()) {
                                            
                                            out.println("<center><h3>"+it.next() + "</h3></center>");
                                        } %>
                                       
                                    <%}
                                    err.clear();
                          }
                          
                          out.println("<center><h2><u>INSTRUCTIONS</u></h2></center>");
                    %>
                     
                    <ul>
                        <li><h3>HOME contains general instructions and Updates.</h3></li>
                        <li><h3>SCHEDULE has Placement Schedule.</h3></li>
                        <li><h3>COMPANIES has list of all companies arriving to the campus.</h3></li>
                        <li><h3>COMPANY DETAILS has additional information provided by companies.</h3></li>
                        <li><h3>APPLY is the place where you can apply to all the companies which you are eligible.</h3></li>
                        <li><h3>You can edit your personal details in EDIT DETAILS section.</h3></li>
                        <li><h3>UPLOAD CV is the place where you can upload your CV. CV-1 : Technical CV . CV-2 : Non-Technical CV . </h3></li>
                        <li><h3>NOTE:- You can upload your CV only once..</h3></li>
                        <li><h3>You can view all the rules and regulations of placement call under PLACEMENT POLICIES</h3></li>
                        <li><h3>Hit LOG OUT to end your session</h3></li>
                    </ul>
                    <hr>
                    
                    <center><h2><u>UPDATES</u></h2></center>
                    <%
                        MyDB m = new MyDB();
                        ArrayList arr = m.getUpdates();
                        Iterator it = arr.iterator();
                    %>
                    <ul>
                        <% while (it.hasNext()) {%>
                        <li><B> <% out.println(it.next());%> </B></li>
                                <% }%>
                        
                    </ul>
                     <%     
                      }
                    %>
                    
                    
                    
                    
                    
                    
                    
                    <%
                      if(((String)request.getAttribute("click")).equals("COMPANIES"))
                      {
                          ArrayList[] Companies=(ArrayList[])request.getAttribute("Companies");
                          out.println("<center><h1>COMPANIES VISITING</h1></center>");
                          String filePath = application.getInitParameter("company-file-upload");
                    %>
                         
                     
                       <table class="hovertable" style="width:95%; position: absolute; top: 13%; bottom: 0; left: 0; right: 5%; float: left; " border="1">
                       <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <th>NAME </th>
                           <th>TYPE</th>
                           <th>SECTOR </th>
                           <th>WEBSITE</th>
                           <th>LOCATION</th>
                           <th>CTC</th>
                           <th>DEPARTMENTS</th>
                           <th>CPI CUTOFF</th>
                           <th>MORE DETAILS</th>
                        </tr>
                        
                        <%
                         Iterator it1=Companies[0].iterator();
                         Iterator it2=Companies[1].iterator();
                         Iterator it3=Companies[2].iterator();
                         Iterator it4=Companies[3].iterator();
                         Iterator it5=Companies[4].iterator();
                         Iterator it6=Companies[5].iterator();
                         Iterator it7=Companies[6].iterator();
                         Iterator it8=Companies[7].iterator();
                         Iterator it9=Companies[9].iterator();
                         Iterator it10=Companies[8].iterator();
                        %>
                        
                        
                        <% while(it1.hasNext())
                         { 
                        %>
                             <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <%
                             out.println("<td align='center'>"+it1.next()+"</td>");
                             out.println("<td align='center'>"+it2.next()+"</td>");
                             out.println("<td align='center'>"+it3.next()+"</td>");
                             out.println("<td align='center'>"+it4.next()+"</td>");
                             out.println("<td align='center'>"+it5.next()+"</td>");
                             out.println("<td align='center'>"+(Float)it6.next()+"</td>");
                             out.println("<td align='center'>"+it7.next()+"</td>");
                             out.println("<td align='center'>"+it8.next()+"</td>");%>
                             <td align="center">
                                 <% 
                                    String link=(String)it9.next();
                                    String id=(String)it10.next();
                                    if(!link.equals("-"))
                                    { %>
                                   
                                    <a href='<%="file:///"+filePath+id+"\\"+link%>' target="_blank" >click</a>
                                    
                                    <% } 
                                    else{
                                        out.println("----");
                                    }
                                    %>
                             </td>
                           <%  out.println("</tr>");
                         }
                         
                         
                        %>
                       
                       </table>
                     <% }
                    %>
                    
                    
                    
                    
                    <%
                      if(((String)request.getAttribute("click")).equals("SCHEDULE"))
                      { ArrayList[] Schedule=(ArrayList[])request.getAttribute("Schedule");
                          out.println("<center><h1>SCHEDULE</h1></center>"); %>
                          
                     
                       <table class="hovertable" style="width:95%; position: absolute; top: 13%; bottom: 0; left: 0; right: 5%; float: left; " border="1">
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
                         {
                         %>   
                         <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                          <%  
                             out.println("<td align='center'>"+it1.next()+"</td>");
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
                  
                    
                    
                 <!-- UPLOAD CV PART  -->   
                 <%
                 if(((String)request.getAttribute("click")).equals("UPLOAD CV"))
                 { %>
                 <table class="hovertable" style="width:95%; position: absolute; top: 13%; bottom: 0; left: 0; right: 5%; float: left; " border="0">
                     <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';"><td><fieldset>
                     <legend>UPLOAD CV</legend> 
                     <form action="Stud_CV_Upload" method="POST" enctype="multipart/form-data">
                     UPLOAD CV-1:
                     <input type="file" name="cv1" ><br>
                     UPLOAD CV-2:
                     <input type="file" name="cv2" ><br>
                     <input type="submit" name="upload" value="UPLOAD" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
                     </form>
                 </fieldset></td></tr>
                  
                 </table>
                 <%} %>
                 
                 
                 
                 
                <!-- APPLYING FOR COMPANIES PART  -->  
                 
                  <%
                 if(((String)request.getAttribute("click")).equals("APPLY"))
                 { 
                 out.println("<h1><center>YOU CAN APPLY TO FOLLOWING COMPANIES</center></h1>");
                 ArrayList[] EligibleCompanies=(ArrayList[])request.getAttribute("EligibleComapnies");
                 ArrayList CVs=(ArrayList)request.getAttribute("CVs");
                 String cv1= (String)CVs.get(0);
                 String cv2= (String)CVs.get(1);
                 %>
                 
                 <form action="Student_Home_Process" method="POST" > 
                 <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">
                     
                     
                      <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <th>SELECT</th>
                           <th>NAME </th>
                           <th>TYPE</th>
                           <th>SECTOR </th>
                           <th>WEBSITE</th>
                           <th>LOCATION</th>
                           <th>CTC</th>
                           <th>CV</th>
                          
                        </tr>
                        
                        <%
                         Iterator it1= EligibleCompanies[0].iterator();
                         Iterator it2=EligibleCompanies[1].iterator();
                         Iterator it3=EligibleCompanies[2].iterator();
                         Iterator it4=EligibleCompanies[3].iterator();
                         Iterator it5=EligibleCompanies[4].iterator();
                         Iterator it6=EligibleCompanies[5].iterator();
                         //Iterator it7=EligibleCompanies[6].iterator();
                         
                         
                         while(it1.hasNext())
                         {
                             String Name=(String)it1.next();
                             String Sector=(String)it3.next();
                         %>
                         <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                         <%    
                             out.println("<td align='center'><input type='checkbox' name='checkbox' value='"+Name+","+Sector+"'></td> ");
                             out.println("<td align='center'>"+Name+"</td>");
                             out.println("<td align='center'>"+it2.next()+"</td>");
                             out.println("<td align='center'>"+Sector+"</td>");
                             out.println("<td align='center'>"+it4.next()+"</td>");
                             out.println("<td align='center'>"+it5.next()+"</td>");
                             out.println("<td align='center'>"+(Float)it6.next()+"</td>");
                            
                             out.println("<td align='center'> <select name='"+Name+","+Sector+"'>");  %>
                
                                     <%
                                           out.println("<option value='"+cv1+"'>"+"cv-"+1+"</option>");
                                           out.println("<option value='"+cv2+"'>"+"cv-"+2+"</option>");
                                     %>         
                                     </select> </td>
                            <% out.println("</tr>");
                         }
                         
                         
                        %>
                        </table>
                        
                        <center>
                        <input type="submit" name="upload" value="APPLY" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" ></center>
                        </form>
                        
                      <% } %>
                      
                      
                     
                      
                      
                       <!-- GET APPLIED COMPANIES PART  -->  
                 
                  <%
                 if(((String)request.getAttribute("click")).equals("COMPANIES APPLIED"))
                 { 
                 out.println("<h1><center> COMPANIES YOU HAVE APPLIED</center></h1>");
                 ArrayList[] AppliedCompanies=(ArrayList[])request.getAttribute("AppliedCompanies");
                 String filePath = application.getInitParameter("stud-file-upload");
                 %>
                 
                 
                 <table class="hovertable" style="width:95%;  left: 5%; right: 5%; float: left; " border="1">
                     
                     
                      <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                           <th>NAME </th>                           
                           <th>SECTOR </th>
                           <th>CV</th>
                      </tr>
                        
                        <%
                         Iterator it11= AppliedCompanies[0].iterator();
                         Iterator it12=AppliedCompanies[1].iterator();
                         Iterator it13=AppliedCompanies[2].iterator();
                         
                         Integer rno=(Integer)session.getAttribute("rno");
                         while(it11.hasNext())
                         {
                          %> 
                          <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                             
                           <%  
                             out.println("<td align='center'>"+it11.next()+"</td>");
                             out.println("<td align='center'>"+it12.next()+"</td>"); %>
                             
                              <% String link=(String)it13.next();
                                 if(!link.equals("-")){ %>
                                  
                                 
                                        <td align="center"> <a href='<%="file:///"+filePath+rno+"\\"+link%>' target="_blank" >click</a> </td>                         
                                    <%}
                                    else{ %>
                                    <td align="center">----</td>
                                    
                                  <%  }
                             out.println("</tr>");
                         }     
                         
                        %>
                 </table>
                     
                 <% 
                     }
                 %>
                        
                        
                
                 
	</td>
    </tr>
	
	
</table>
</body>
</html>