/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PR;

import Common.MyDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author V.BhargavaMourya
 */
public class PR_Update_Verification extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
           if(request.getParameter("button").equals("UPDATE"))
            {
                ArrayList err=new ArrayList();
                ArrayList updating=new ArrayList();
                HttpSession session= request.getSession(false);
                MyDB m = new MyDB();
                
                
                updating.add(request.getParameter("gender"));
                if(request.getParameter("dob").trim()=="")
                {
                    err.add("DATE OF BIRTH CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("dob").trim());
                }
                               
                if(request.getParameter("mother").trim()=="")
                {
                    err.add("MOTHER NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("mother").trim());
                }
                
                if(request.getParameter("father").trim()=="")
                {
                    err.add("FATHER'S NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("father").trim());
                }
                
                if(request.getParameter("present").trim()=="")
                {
                    err.add("PRESENT ADDRESS CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("present").trim());
                }
                
                if(request.getParameter("permanent").trim()=="")
                {
                    err.add("PERMANENT ADDRESS CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("permanent").trim());
                }
                
                 if(request.getParameter("email").trim()=="")
                {
                    err.add("EMAIL ADDRESS CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("email").trim());
                }
                    
                 
                try
                {
                    float tenth = Float.parseFloat(request.getParameter("tenth").trim());
                    if(tenth<=100)
                    {
                    updating.add(tenth);
                    }
                    else
                    {
                        err.add("TENTH PERCENTAGE CANNOT BE GREATER THAN 100");
                    }

                } 
                catch (Exception e)
                {
                    err.add("TENTH PERCENTAGE MUST BE LESS THAN OR EQUAL TO 100");
                }
                   
                
                try
                {
                    float twelth = Float.parseFloat(request.getParameter("tenth").trim());
                    if(twelth<100)
                    {
                    updating.add(twelth);
                    }
                    else
                    {
                        err.add("TWELTH PERCENTAGE CANNOT BE GREATER THAN 100");
                    }

                } 
                catch (Exception e)
                {
                    err.add("TWELTH PERCENTAGE MUST BE LESS THAN OR EQUAL TO 100");
                }       
                    
                
                if(!err.isEmpty())
                {
                    updating.clear();
                    request.setAttribute("err", err);
                    ArrayList RegisteredStudentInfoForUpdating=m.getRegisteredStudentInfoForUpdating((Integer)session.getAttribute("rno"));
                    request.setAttribute("RegisteredStudentInfoForUpdating",RegisteredStudentInfoForUpdating);
                    RequestDispatcher rd=request.getRequestDispatcher("PR_Update_Details");
                    rd.forward(request, response);
                }
                
                else
                {
                    if(m.UpdateStudentDetails((Integer)session.getAttribute("rno"),updating))
                    {
                        err.add("UPDATED SUCCESSFULLY!!");
                        request.setAttribute("err", err);
                        String click;
                        click = "HOME";
                        request.setAttribute("click", click);
                        RequestDispatcher rd=request.getRequestDispatcher("PR_Home");
                        rd.forward(request, response);
                    }
                    else
                    {
                         //err.add(updating);
                         err.add("<h2>UPDATE FAILED</h2>");
                    }
                    request.setAttribute("err", err);
                    ArrayList RegisteredStudentInfoForUpdating=m.getRegisteredStudentInfoForUpdating((Integer)session.getAttribute("rno"));
                    request.setAttribute("RegisteredStudentInfoForUpdating",RegisteredStudentInfoForUpdating);
                    RequestDispatcher rd=request.getRequestDispatcher("PR_Update_Details");
                    rd.forward(request, response);
                }
                
                
            }
            else
            {   
                String click;
                click="HOME";
                request.setAttribute("click", click);
               RequestDispatcher rd=request.getRequestDispatcher("PR_Home");
              rd.forward(request, response);
            }
        }  finally {            
            out.close();
        }
    }

  
}
