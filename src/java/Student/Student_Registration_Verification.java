/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import Common.MyDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author V.BhargavaMourya
 */
public class Student_Registration_Verification extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            
            if(request.getParameter("button").equals("REGISTER"))
            {
                ArrayList err=new ArrayList();
                ArrayList adding=new ArrayList();
                
                MyDB m = new MyDB();
                int rno=m.isStudentACurrentStudent(request.getParameter("webmail").trim(),request.getParameter("password").trim());
                
                
                if (rno==-1)
                {
                    err.add("<h3>YOU ARE NOT ENROLLED IN IIT GUWAHATI!!! YOU CANT SIT FOR PLACEMENTS</h3>");
                } 
                else                 
                {
                    adding.add(rno);
                }
                
                adding.add(request.getParameter("gender"));
                if(request.getParameter("dob").trim()=="")
                {
                    err.add("DATE OF BIRTH CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("dob").trim());
                }
                               
                if(request.getParameter("mother").trim()=="")
                {
                    err.add("MOTHER NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("mother").trim());
                }
                
                if(request.getParameter("father").trim()=="")
                {
                    err.add("FATHER'S NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("father").trim());
                }
                
                if(request.getParameter("present").trim()=="")
                {
                    err.add("PRESENT ADDRESS CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("present").trim());
                }
                
                if(request.getParameter("permanent").trim()=="")
                {
                    err.add("PERMANENT ADDRESS CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("permanent").trim());
                }
                
                 if(request.getParameter("email").trim()=="")
                {
                    err.add("EMAIL ADDRESS CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("email").trim());
                }
                    
                 
                try
                {
                    float tenth = Float.parseFloat(request.getParameter("tenth").trim());
                    if(tenth<100)
                    {
                    adding.add(tenth);
                    }
                    else
                    {
                        err.add("TENTH PERCENTAGE MUST BE LESS THAN 100");
                    }

                } 
                catch (Exception e)
                {
                    err.add("TENTH PERCENTAGE MUST BE LESS THAN 100");
                }
                   
                
                try
                {
                    float twelth = Float.parseFloat(request.getParameter("twelth").trim());
                    if(twelth<100)
                    {
                    adding.add(twelth);
                    }
                    else
                    {
                        err.add("TWELTH PERCENTAGE MUST BE LESS THAN 100");
                    }

                } 
                catch (Exception e)
                {
                    err.add("TWELTH PERCENTAGE MUST BE LESS THAN 100");
                }       
                    
                
                if(!err.isEmpty())
                {
                    adding.clear();
                    request.setAttribute("err", err);
                    RequestDispatcher rd=request.getRequestDispatcher("Student_Registration_Page");
                    rd.forward(request, response);
                }
                
                else
                {
                    if(m.addNewStudent(adding))
                    {
                        err.add("<h2><B>registration Successful..GO BACK AND LOGIN</B></h2>");
                    }
                    else
                    {
                         //err.add(adding);
                         err.add("<h2>You Have Already Registered</h2>");
                    }
                    request.setAttribute("err", err);
                    RequestDispatcher rd=request.getRequestDispatcher("Student_Registration_Page");
                    rd.forward(request, response);
                }
                
                
            }
            else
            {
               RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
              rd.forward(request, response);
            }
            
        } finally {            
            out.close();
        }
    }

   
}
