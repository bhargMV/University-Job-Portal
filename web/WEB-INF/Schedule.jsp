<%-- 
    Document   : Schedule
    Created on : Mar 30, 2013, 5:03:21 PM
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
        ArrayList[] Schedule = (ArrayList[]) m.getSchedule();
        out.println("<center><h1>SCHEDULE</h1></center>");
    %>


    <table class="hovertable" style="width:80%; position: absolute; top: 10%; bottom: 0; left: 10%; right: 10%; float: left; " border="1">
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
            <th>COMPANY</th>
            <th>SECTOR </th>
            <th>WRITTEN TEST</th>
            <th>TIME SLOT</th>
            <th>VENUE</th>
            <th>DAY</th>

        </tr>

        <%
            Iterator it1 = Schedule[0].iterator();
            Iterator it2 = Schedule[1].iterator();
            Iterator it3 = Schedule[2].iterator();
            Iterator it4 = Schedule[3].iterator();
            Iterator it5 = Schedule[4].iterator();
            Iterator it6 = Schedule[5].iterator();


           while (it1.hasNext()) 
            {
        %>
        <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='mistyrose';">
            <%      
                    out.println("<td align='center'>" + it1.next() + "</td>");
                    out.println("<td align='center'>" + it2.next() + "</td>");
                    out.println("<td align='center'>" + it3.next() + "</td>");
                    out.println("<td align='center'>" + it4.next() + "</td>");
                    out.println("<td align='center'>" + it5.next() + "</td>");
                    out.println("<td align='center'>" + (Integer) it6.next() + "</td>");

                    out.println("</tr>");
                }


            %>
    </table>
    
</body>
