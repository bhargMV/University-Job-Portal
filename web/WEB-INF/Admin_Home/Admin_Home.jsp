<%-- 
    Document   : Admin_Home
    Created on : Mar 7, 2013, 12:20:53 AM
    Author     : V.BhargavaMourya
--%>

<%@page import="Common.MyDB"%>
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
                        <form action="Admin_Home_Process" method="POST">
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="HOME"  style="background-color:yellowgreen; font-size:18; width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="REGISTERED STUDENTS" style="background-color:yellowgreen;font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>

                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="REGISTERED COMPANIES" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                           
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="APPLICATIONS" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="PLACEMENT SCHEDULE" style="background-color:yellowgreen; font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input TYPE="submit" name="button" VALUE="PLACEMENT STATISTICS"  style="background-color:yellowgreen; font-size:18;    width: 100%; height: 110%;"  Cellpadding='0'>
                                </td></tr>
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="ADD PRIVILEGES" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="EDIT UPDATES" style="background-color:yellowgreen;  font-size:18;    width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                            <tr><td style="width:13%;" cellspacing="0" cellpadding="0">
                                    <input type="submit" name="button" value="LOG OUT" style="background-color:yellowgreen;  font-size:18;   width: 100%; height: 110%;" Cellpadding='0'>
                                </td></tr>
                        </form>	
                    </table>
                </td>

                <td style="height:90%;width:84%; position: absolute; top: 10%; bottom: 0; left: 16%; right: 0; float: left; " border='0'>

                    <%
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
                      if(((String)request.getAttribute("click")).equals("HOME"))
                      {
                          out.println("<center><h1>Welcome     "+(String)session.getAttribute("loginid")+" !!</h1></center>");
                          
                          
                          
                          out.println("<center><h2><u>INSTRUCTIONS</u></h2></center>");
                    %>

                    <ul>
                        <li><h3>HOME contains general instructions and Updates.</h3></li>
                        <li><h3>You can see Registered Students for Placements Under Register Students</h3></li>
                        <li><h3>REGISTERED COMPANIES has list of all companies arriving to the campus.</h3></li>
                        <li><h3>You can see details of students applying to companies under APPLICATIONS</h3></li>
                        <li><h3>SCHEDULE has Placement Schedule. You can add & Modify existing schedule</h3></li>
                        <li><h3>PLACEMENT STATISTICS has current Statics of Placement.</h3></li>
                        <li><h3>You can view all the rules and regulations of placement call under PLACEMENT POLICIES</h3></li>
                        <li><h3>Hit LOG OUT to end your session</h3></li>
                    </ul>
                    <hr>


                    <%
                        }
                    %>



                    <%
                        if (((String) request.getAttribute("click")).equals("REGISTERED STUDENTS")) {
                            out.println("<h1><center> FOLLOWING STUDENTS REGISTERED FOR PLACEMENTS</center></h1>");
                            ArrayList[] RegisteredStudents = (ArrayList[]) request.getAttribute("RegisteredStudents");
                            String filePath = application.getInitParameter("stud-file-upload");
                    %>


                    <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">



                        <tr onmouseover="this.style.backgroundColor = '#ffff66';" onmouseout="this.style.backgroundColor = 'mistyrose';">
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
                            <th>CV-1</th>
                            <th>CV-2</th>

                        </tr>

                        <%
                            Iterator it11 = RegisteredStudents[0].iterator();
                            Iterator it12 = RegisteredStudents[1].iterator();
                            Iterator it13 = RegisteredStudents[2].iterator();
                            Iterator it14 = RegisteredStudents[3].iterator();
                            Iterator it15 = RegisteredStudents[4].iterator();
                            Iterator it16 = RegisteredStudents[5].iterator();
                            Iterator it17 = RegisteredStudents[6].iterator();
                            Iterator it18 = RegisteredStudents[7].iterator();
                            Iterator it19 = RegisteredStudents[8].iterator();
                            Iterator it20 = RegisteredStudents[9].iterator();
                            Iterator it21 = RegisteredStudents[10].iterator();
                            Iterator it22 = RegisteredStudents[11].iterator();
                            Iterator it23 = RegisteredStudents[12].iterator();
                            Iterator it24 = RegisteredStudents[13].iterator();

                            while (it11.hasNext()) {
                        %> 
                        <tr onmouseover="this.style.backgroundColor = '#ffff66';" onmouseout="this.style.backgroundColor = 'mistyrose';">

                            <%
                                    int rno=(Integer) it11.next();
                                    out.println("<td align='center'>" +rno + "</td>");
                                    out.println("<td align='center'>" + it12.next() + "</td>");
                                    out.println("<td align='center'>" + it13.next() + "</td>");
                                    out.println("<td align='center'>" + it14.next() + "</td>");
                                    out.println("<td align='center'>" + it15.next() + "</td>");
                                    out.println("<td align='center'>" + it16.next() + "</td>");
                                    out.println("<td align='center'>" + it17.next() + "</td>");
                                    out.println("<td align='center'>" + it18.next() + "</td>");
                                    out.println("<td align='center'>" + it19.next() + "</td>");
                                    out.println("<td align='center'>" + it20.next() + "</td>");
                                    out.println("<td align='center'>" + it21.next() + "</td>");
                                    out.println("<td align='center'>" + it22.next() + "</td>"); 
                                    
                            %>
                                       <td align="center">
                                 <% 
                                    String link=(String)it23.next();
                                    
                                    if(!link.equals("-"))
                                    { %>
                                   
                                    <a href='<%="file:///"+filePath+rno+"\\"+link%>' target="_blank" >click</a>
                                    
                                    <% } 
                                    else{
                                        out.println("----");
                                    }
                                    %>
                             </td>
                             
                              <td align="center">
                                 <% 
                                    link=(String)it24.next();
                                    
                                    if(!link.equals("-"))
                                    { %>
                                   
                                    <a href='<%="file:///"+filePath+rno+"\\"+link%>' target="_blank" >click</a>
                                    
                                    <% } 
                                    else{
                                        out.println("----");
                                    }
                                    %>
                             </td> 
                                 
                                   <% out.println("</tr>");
                                }


                            %>
                    </table>

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
                           <th>CONTACT NAME</th>
                           <th>DESIGNATION</th>
                           <th>E-MAIL</th>
                           <th>MOBILE</th>
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
                         Iterator it11=Companies[10].iterator();
                         Iterator it12=Companies[11].iterator();
                         Iterator it13=Companies[12].iterator();
                         Iterator it14=Companies[13].iterator();
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
                             out.println("<td align='center'>"+it8.next()+"</td>");
                             out.println("<td align='center'>"+it11.next()+"</td>");
                             out.println("<td align='center'>"+it12.next()+"</td>");
                             out.println("<td align='center'>"+it13.next()+"</td>");
                             out.println("<td align='center'>"+it14.next()+"</td>");
                           
                           %>
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
                           <% 
                                    out.println("</tr>");
                         }
                         
                         
                        %>
                       
                       </table>
                     <% }
                    %>
                    
                    
                    
                    

                    <!-- GET ALL APPLICATIONS PART  -->  

                    <%
                        if (((String) request.getAttribute("click")).equals("APPLICATIONS")) {
                            out.println("<h1><center> FOLLOWING STUDENTS APPLIED FOR PLACEMENTS</center></h1>");
                            ArrayList[] AppliedStudents = (ArrayList[]) request.getAttribute("AppliedStudents");
                            String filePath = application.getInitParameter("stud-file-upload");
                    %>


                    <form action="Admin_Home_Process" method="POST" > 
                 <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">


                        <tr onmouseover="this.style.backgroundColor = '#ffff66';" onmouseout="this.style.backgroundColor = 'mistyrose';">
                            <th>SELECT</th>
                            <th>ROLL NO </th>                           
                            <th>NAME </th>
                            <th>WEBMAIL</th>
                            <th>PROGRAMME</th>
                            <th>DEPARTMENT</th>
                            <th>COMPANY</th>
                            <th>SECTOR</th>
                            <th>CV</th>
                        </tr>

                        <%
                            Iterator it11 = AppliedStudents[0].iterator();
                            Iterator it12 = AppliedStudents[1].iterator();
                            Iterator it13 = AppliedStudents[2].iterator();
                            Iterator it14 = AppliedStudents[3].iterator();
                            Iterator it15 = AppliedStudents[4].iterator();
                            Iterator it16 = AppliedStudents[5].iterator();
                            Iterator it17 = AppliedStudents[6].iterator();
                            Iterator it18 = AppliedStudents[7].iterator();


                            while (it11.hasNext()) {
                        %> 
                        <tr onmouseover="this.style.backgroundColor = '#ffff66';" onmouseout="this.style.backgroundColor = 'mistyrose';">

                            <%
                                    int rno=(Integer) it11.next();
                                    String Name=(String)it16.next();
                                    String Sector=(String)it17.next();
                                    out.println("<td align='center'><input type='checkbox' name='deletions' value='"+rno+","+Name+","+Sector+"'></td> ");
                                    out.println("<td align='center'>" + rno + "</td>");
                                    out.println("<td align='center'>" + it12.next() + "</td>");
                                    out.println("<td align='center'>" + it13.next() + "</td>");
                                    out.println("<td align='center'>" + it14.next() + "</td>");
                                    out.println("<td align='center'>" + it15.next() + "</td>");
                                    out.println("<td align='center'>" + Name + "</td>");
                                    out.println("<td align='center'>" + Sector + "</td>"); %>

                                   <td align="center">
                                 <% 
                                    String link=(String)it18.next();
                                    
                                    if(!link.equals("-"))
                                    { %>
                                   
                                    <a href='<%="file:///"+filePath+rno+"\\"+link%>' target="_blank" >click</a>
                                    
                                    <% } 
                                    else{
                                        out.println("----");
                                    }
                                    %>
                             </td>
                               <%     out.println("</tr>");
                                }

                            
                            %>
                    </table>
                    
                        <center><input type="submit" name="delete" value="DELETE APPLICATIONS" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" ></center>
                        </form>

                    <%
                        }
                    %>
                    
                    
                    
                    
                    <!-- Edit Placement Schedule-->
                    <%
                        if (((String) request.getAttribute("click")).equals("PLACEMENT SCHEDULE")) {
                        ArrayList[] PlacementSchedule = (ArrayList[]) request.getAttribute("PlacementSchedule");
                       
                        out.println("<center><h1>PLACEMENT SCHEDULE</h1></center>");
                    %>

                     <form action="Admin_Home_Process" method="POST" > 
                    <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <th>COMPANY</th>
                            <th>SECTOR </th>
                            <th>WRITTEN TEST</th>
                            <th>TIME SLOT</th>
                            <th>VENUE</th>
                            <th>DAY</th>
                            <th>SELECT</th>
                        </tr>

                        <%
                            Iterator it1 = PlacementSchedule[0].iterator();
                            Iterator it2 = PlacementSchedule[1].iterator();
                            Iterator it3 = PlacementSchedule[2].iterator();
                            Iterator it4 = PlacementSchedule[3].iterator();
                            Iterator it5 = PlacementSchedule[4].iterator();
                            Iterator it6 = PlacementSchedule[5].iterator();


                            while (it1.hasNext()) {
                        %>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <%
                                    String company=(String)it1.next();
                                    String sector=(String)it2.next();
                                    out.println("<td align='center'>" + company + "</td>");
                                    out.println("<td align='center'>" + sector + "</td>");
                                    out.println("<td align='center'>" + it3.next() + "</td>");
                                    out.println("<td align='center'>" + it4.next() + "</td>");
                                    out.println("<td align='center'>" + it5.next() + "</td>");
                                    out.println("<td align='center'>" + (Integer) it6.next() + "</td>");
                                    out.println("<td align='center'><input type='checkbox' name='deleteschedule' value='"+company+","+sector+"'></td> ");
                                    out.println("</tr>");
                                }

                                    
                            %>
                    </table><br/>
                    <center><input type="submit" name="changeschedule" value="DELETE" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" ></center>
                    <h3></h3>
                    <h3>ADD TO SCHEDULE:</h3>
                    <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <th>COMPANY</th>
                            <th>SECTOR </th>
                            <th>WRITTEN TEST</th>
                            <th>TIME SLOT</th>
                            <th>VENUE</th>
                            <th>DAY</th>
                            <th>SELECT</th>
                        </tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <%
                                    out.println("<td align='center'><input type='text' name='addcompany' ></td>");
                                    out.println("<td align='center'><input type='text' name='addsector' ></td>");
                                    out.println("<td align='center'><input type='text' name='writtentest' ></td>");
                                    out.println("<td align='center'><input type='text' name='timeslot' ></td>");
                                    out.println("<td align='center'><input type='text' name='venue' ></td>");
                                    out.println("<td align='center'><input type='text' name='day' ></td>");
                                    out.println("<td align='center'><input type='checkbox' name='addschedule'></td> ");
                            %>
                    </table><br/>
                    <center><input type="submit" name="changeschedule" value="ADD" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" ></center>
                        </form>

                     <%
                        }
                    %>
                    
                    
                    
                    
                    
                    <!-- Edit Updates-->
                    <%
                        if (((String) request.getAttribute("click")).equals("EDIT UPDATES")) {
                        ArrayList Updates = (ArrayList) request.getAttribute("Updates");
                       
                        out.println("<center><h1>UPDATES</h1></center>");
                    %>

                     <form action="Admin_Home_Process" method="POST" > 
                    <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <th>Update</th>
                            <th>SELECT</th>
                        </tr>

                        <%
                            Iterator it1 = Updates.iterator();
                            


                            while (it1.hasNext()) {
                        %>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <%
                                    String Update=(String)it1.next();
                                    
                                    out.println("<td align='center'>" + Update + "</td>");
                                    
                                    out.println("<td align='center'><input type='checkbox' name='deleteupdate' value='"+Update+"'></td> ");
                                    out.println("</tr>");
                                }

                                    
                            %>
                    </table><br/>
                    <center><input type="submit" name="changeupdate" value="DELETE" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" ></center>
                    <h3></h3>
                    <h3>ADD UPDATE:</h3>
                    <table class="hovertable" style="width:95%;  left: 0; right: 5%; float: left; " border="1">
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <th>TEXT</th>
                            <th>SELECT</th>
                        </tr>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <%
                                    out.println("<td align='center'><input type='text' name='updatetext' ></td>");
                                    
                                    out.println("<td align='center'><input type='checkbox' name='addupdate'></td> ");
                            %>
                    </table><br/>
                    <center><input type="submit" name="changeupdate" value="ADD" style="background-color:yellowgreen;  font-size:18;   left: 20%; right: 5%;  width: 20%; height: 40px;" ></center>
                        </form>

                     <%
                        }
                    %>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    <!-- Edit Placement Statistics-->
                    <%
                        if (((String) request.getAttribute("click")).equals("PLACEMENT STATISTICS")) {
                        ArrayList[] PlacementStatics = (ArrayList[]) request.getAttribute("PlacementStatics");
                       
                        out.println("<center><h1>PLACEMENT STATISTICS</h1></center>");
                    %>


                    <table class="hovertable" style="width:90%; position: absolute; top: 13%; bottom: 0; left: 5%; right: 5%; float: left; " border="1">
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
                            <th>ROLL</th>
                            <th>NAME </th>
                            <th>WEBMAIL</th>
                            <th>PROGRAMME</th>
                            <th>DEPARTMENT</th>
                            <th>COMPANY</th>
                            <th>SECTOR</th>

                        </tr>

                        <%
                            Iterator it1 = PlacementStatics[0].iterator();
                            Iterator it2 = PlacementStatics[1].iterator();
                            Iterator it3 = PlacementStatics[2].iterator();
                            Iterator it4 = PlacementStatics[3].iterator();
                            Iterator it5 = PlacementStatics[4].iterator();
                            Iterator it6 = PlacementStatics[5].iterator();
                            Iterator it7 = PlacementStatics[6].iterator();

                            while (it1.hasNext()) {
                        %>
                        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">                           
                            <%  out.println("<td align='center'>" + it1.next() + "</td>");
                                    out.println("<td align='center'>" + it2.next() + "</td>");
                                    out.println("<td align='center'>" + it3.next() + "</td>");
                                    out.println("<td align='center'>" + it4.next() + "</td>");
                                    out.println("<td align='center'>" + it5.next() + "</td>");
                                    out.println("<td align='center'>" + it6.next() + "</td>");
                                    out.println("<td align='center'>" + it7.next() + "</td>");
                                    out.println("</tr>");
                                }


                            %>
                    </table>
                     <%
                        }
                    %>
                    
                    
                    
                    
                    <% 
                         if (((String) request.getAttribute("click")).equals("ADD PRIVILEGES")) {
                        out.println("<center><h1>ADD PRIVILEGES</h1></center>");
                        
                        
                        %>
                        <form method="POST" action="Admin_Home_Process">
                            
                            <fieldset>
                                <legend>ADD ADMIN</legend>
                                CREATE LOGIN ID:<input type="text" name="adminlogin"><br>
                                CREATE PASSWORD:<input type="text" name="adminpassword"><br>
                                Add ADMIN:<input type='checkbox' name='additions' value='ADD ADMIN'><br>
                            </fieldset>
                            <br>
                             <fieldset>
                                <legend>REPLACE PR</legend>
                                Student's Webmail:<input type="text" name="prroll"><br>
                                Replace PR:<input type='checkbox' name='additions' value='REPLACE PR'><br>
                            </fieldset>
                            <br>
                            <input type="submit" name="privileges" value="SUBMIT" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
                            <input type="submit" name="privileges" value="GO BACK" style="background-color:yellowgreen;  font-size:18;    width: 15%; height: 30px;" > 
                        </form>
                        
                        
                        <% } %>
                </td>
            </tr>
        </table>
    </body>
</html>
