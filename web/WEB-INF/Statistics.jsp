<%-- 
    Document   : Statistics
    Created on : Mar 30, 2013, 5:00:59 PM
    Author     : V.BhargavaMourya
--%>

<%@page import="Common.MyDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
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
        
</head>
<body>
        
       <% 
           MyDB m= new MyDB();
           ArrayList[] SelectedStudents=m.getPlacementTable();
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
                         Iterator it1=SelectedStudents[0].iterator();
                         Iterator it2=SelectedStudents[1].iterator();
                         Iterator it3=SelectedStudents[2].iterator();
                         Iterator it4=SelectedStudents[3].iterator();
                         Iterator it5=SelectedStudents[4].iterator();
                         Iterator it6=SelectedStudents[5].iterator();
                         Iterator it7=SelectedStudents[6].iterator();
                         
                         while(it1.hasNext())
                         { 
                        %>
                            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">                           
                         <%  out.println("<td align='center'>"+it1.next()+"</td>");
                             out.println("<td align='center'>"+it2.next()+"</td>");
                             out.println("<td align='center'>"+it3.next()+"</td>");
                             out.println("<td align='center'>"+it4.next()+"</td>");
                             out.println("<td align='center'>"+it5.next()+"</td>");
                             out.println("<td align='center'>"+it6.next()+"</td>");
                             out.println("<td align='center'>"+it7.next()+"</td>");
                             out.println("</tr>");
                         }
                         
                         
                        %>
                       </table>
        
</body>
</html>
