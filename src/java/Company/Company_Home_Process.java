/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Company;

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
public class Company_Home_Process extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            String str=request.getParameter("button");
            String str2=request.getParameter("upload");
            HttpSession session= request.getSession(false);
            MyDB m= new MyDB();
            
            String click;
            
            if (str==null)
                    str="";
            if (str2==null)
                    str2="";
            
            if(str.equals("HOME"))
            {
                click="HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response);
            }
            
            if(str.equals("SCHEDULE"))
            {   
                ArrayList[] Schedule=m.getSchedule();
                request.setAttribute("Schedule",Schedule);
                
                click="SCHEDULE";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response);
            }
            
            
            if(str.equals("APPLIED STUDENTS"))
            {
                ArrayList[] AppliedStudents=m.getAllAppliedStudents((String)session.getAttribute("loginid"));
                request.setAttribute("AppliedStudents",AppliedStudents);
                
                
                
               click="APPLIED STUDENTS";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response); 
            }
            
            if(str2.equals("SELECT"))
            {
                String[] Selections= request.getParameterValues("checkbox");
                
                if(Selections!=null)
                {
                    ArrayList CompanyNameAndSector=m.getCompanyNameAndSector((String)session.getAttribute("loginid")) ;
                    String CompanyName=(String)CompanyNameAndSector.get(0);
                    String Sector=(String)CompanyNameAndSector.get(1);
                    
                    for (int i = 0; i < Selections.length; i++)
                    {
                       int rno = Integer.parseInt(Selections[i]);
                       
                        m.insertIntoPlaced(rno,CompanyName,Sector);
                    }
                }
                click="HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response);
            }
            
            
            if(str.equals("SELECTED STUDENTS"))
            {   
                ArrayList[] SelectedStudents=m.getSelectedStudents((String)session.getAttribute("loginid"));
                request.setAttribute("SelectedStudents",SelectedStudents);
                
                
                click="SELECTED STUDENTS";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response); 
            }
            
            if(str.equals("UPLOAD JOB DETAILS"))
            {
                click="UPLOAD JOB DETAILS";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response);
            }
            
            if(str2.equals("UPLOAD"))
            {
                click="HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response);
            }
            
            if(str.equals("EDIT DETAILS"))
            {
                ArrayList RegisteredCompanyInfoForUpdating=m.getRegisteredCompanyInfoForUpdating((String)session.getAttribute("loginid"));
                request.setAttribute("RegisteredCompanyInfoForUpdating",RegisteredCompanyInfoForUpdating);
                //out.println(RegisteredCompanyInfoForUpdating);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Update_Details");
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
