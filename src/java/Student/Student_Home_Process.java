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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author V.BhargavaMourya
 */
public class Student_Home_Process extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        ArrayList err=new ArrayList();
        request.setAttribute("err", err);
        try {
            
            String str=request.getParameter("button");
            String str2=request.getParameter("upload");
            MyDB m= new MyDB();
            
            String click;
            
            HttpSession session= request.getSession(false);
            
            if (str==null)
                    str="";
            if (str2==null)
                    str2="";
            
            if(str.equals("HOME"))
            {
                click="HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            if(str.equals("SCHEDULE"))
            {   
                ArrayList[] Schedule=m.getSchedule();
                request.setAttribute("Schedule",Schedule);
                
                click="SCHEDULE";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            if(str.equals("COMPANIES"))
            {   
                ArrayList[] Companies=m.getCompanies();
                request.setAttribute("Companies",Companies);
                
                click="COMPANIES";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            if(str.equals("APPLY"))
            {
                ArrayList[] EligibleCompanies=m.getEligibleCompanies((Integer)session.getAttribute("rno"),(String)session.getAttribute("webmail"));
                ArrayList CVs =m.getCVsofStudent((Integer)session.getAttribute("rno"));
                request.setAttribute("EligibleComapnies",EligibleCompanies);
                request.setAttribute("CVs",CVs);
                
                click="APPLY";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            
            if(str2.equals("APPLY"))
            {
                String[] Applications= request.getParameterValues("checkbox");
                
                if(Applications!=null)
                {
                    
                    for (int i = 0; i < Applications.length; i++)
                    {
                        String cv=request.getParameter(Applications[i]);
                        String[] temp = Applications[i].split(",");
                        String Name = temp[0];
                        String Sector = temp[1];
                       
                        m.insertIntoApply((Integer) session.getAttribute("rno"), Name, Sector,cv);
                    }
                }
                click="HOME";
                request.setAttribute("click", click);
                err.add("SUCCESSFULLY APPLIED");
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response); 
            }
            
            if(str.equals("COMPANIES APPLIED"))
            {
                ArrayList[] AppliedCompanies=m.getAppliedCompanies((Integer)session.getAttribute("rno"));
                request.setAttribute("AppliedCompanies",AppliedCompanies);
                click="COMPANIES APPLIED";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            
            
            if(str.equals("EDIT DETAILS"))
            {
                ArrayList RegisteredStudentInfoForUpdating=m.getRegisteredStudentInfoForUpdating((Integer)session.getAttribute("rno"));
                request.setAttribute("RegisteredStudentInfoForUpdating",RegisteredStudentInfoForUpdating);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Update_Details");
                rd.forward(request, response);
            }
            
            if(str.equals("UPLOAD CV"))
            {
                click="UPLOAD CV";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            if(str2.equals("UPLOAD"))
            {
                click="HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Stud_Home");
                rd.forward(request, response);
            }
            
            
            if(str.equals("LOG OUT"))
            {
                RequestDispatcher rd=request.getRequestDispatcher("LOG_OUT");
                rd.forward(request, response);
            }
            
            
            
            
        } finally {            
            out.close();
        }
    }

   
}
