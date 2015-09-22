/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

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
public class Admin_Home_Process extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList err=new ArrayList();
        request.setAttribute("err", err);
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            String str=request.getParameter("button");
            String str2=request.getParameter("upload");
            String delete=request.getParameter("delete");
            String privileges=request.getParameter("privileges");
            String changeschedule=request.getParameter("changeschedule");
            String changeupdate=request.getParameter("changeupdate");
            HttpSession session= request.getSession(false);
            MyDB m= new MyDB();
            
            String click;
            
            if (str==null)
                    str="";
            if (str2==null)
                    str2="";
            if (delete==null)
                    delete="";
            if(privileges==null)
            {
                privileges="";
            }
            if(changeschedule==null)
            {
                changeschedule="";
            }
            if(changeupdate==null)
            {
                changeupdate="";
            }
            
            
            if (str.equals("HOME")) {
                click = "HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }

            if (str.equals("REGISTERED STUDENTS")) {
                ArrayList[] RegisteredStudents = m.getRegisteredStudents();
                request.setAttribute("RegisteredStudents", RegisteredStudents);
                click = "REGISTERED STUDENTS";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            if(str.equals("REGISTERED COMPANIES"))
            {   
                ArrayList[] Companies=m.getCompanies();
                request.setAttribute("Companies",Companies);
                
                click="COMPANIES";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            if (str.equals("APPLICATIONS")) {
                ArrayList[] AppliedStudents = m.getAllAppliedStudents();
                request.setAttribute("AppliedStudents", AppliedStudents);
                click = "APPLICATIONS";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            if(delete.equals("DELETE APPLICATIONS")){
                
                String[] Deletions= request.getParameterValues("deletions");
                
                if(Deletions!=null)
                {
                    
                    for (int i = 0; i < Deletions.length; i++)
                    {
                        
                        String[] temp = Deletions[i].split(",");
                        
                        String rno= temp[0];
                        String Name = temp[1];
                        String Sector = temp[2];
                       
                        //out.println(rno+","+Name+","+Sector);
                        m.deleteFromApply(rno, Name, Sector);
                    }
                }
                err.add("Successfully Deleted the Selected Applications!!");
                ArrayList[] AppliedStudents = m.getAllAppliedStudents();
                request.setAttribute("AppliedStudents", AppliedStudents);
                click = "APPLICATIONS";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }

            
            if (str.equals("PLACEMENT SCHEDULE")) {

                ArrayList[] PlacementSchedule = (ArrayList[]) m.getSchedule();
                request.setAttribute("PlacementSchedule", PlacementSchedule);
                click = "PLACEMENT SCHEDULE";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            
            if(changeschedule.equals("DELETE"))
            {
                
                String[] Deletions= request.getParameterValues("deleteschedule");
                
                if(Deletions!=null)
                {
                    
                    for (int i = 0; i < Deletions.length; i++)
                    {
                        
                        String[] temp = Deletions[i].split(",");
                        
                        String Company= temp[0];                       
                        String Sector = temp[1];
                       
                        //out.println(rno+","+Name+","+Sector);
                        m.deleteFromSchedule( Company, Sector);
                    }
                }
                
                err.add("Successfully Deleted the Selected Schedule!!");
                ArrayList[] PlacementSchedule = (ArrayList[]) m.getSchedule();
                request.setAttribute("PlacementSchedule", PlacementSchedule);
                click = "PLACEMENT SCHEDULE";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            
            if(changeschedule.equals("ADD"))
            {
                    String addschedule= request.getParameter("addschedule");
                    
                    if(addschedule!=null)
                    {
                    
                        String Company= request.getParameter("addcompany");
                        String Sector=  request.getParameter("addsector");
                        String WrittenTest=  request.getParameter("writtentest");
                        String Timeslot=  request.getParameter("timeslot");
                        String Venue=  request.getParameter("venue");
                        String Day=  request.getParameter("day");
                        int day=0;
                        try
                        {
                           day= Integer.parseInt(Day);
                        }
                        catch (Exception ex) 
                        {
                            err.add("DAY must be an integer");
                        }
                        
                        if(Company.equals(""))
                        {
                            err.add("GIVE Company Name");
                        }
                        
                        if(Sector.equals(""))
                        {
                            err.add("GIVE Sector Name");
                        }
                        
                        if(WrittenTest.equals(""))
                        {
                            err.add("Is Written there??");
                        }
                        
                        if(Venue.equals(""))
                        {
                            err.add("Venue cannot be left blank");
                        }
                        
                        if(Timeslot.equals(""))
                        {
                            err.add("GIVE Timeslot");
                        }
                        
                        if(err.isEmpty())
                        {
                            boolean there=m.isDerAnyCompany(Company,Sector);
                            
                            if(!there)
                            {
                                err.add("THIS COMPANY HAS NOT REGISTERED WITH THIS SECTOR !");
                            }
                            
                            else
                            {
                                m.insertIntoSchedule(Company, Sector, WrittenTest,Timeslot,Venue,day);
                            }
                            
                        }
                        
                        
                        if(!err.isEmpty())
                        {
                            
                            ArrayList[] PlacementSchedule = (ArrayList[]) m.getSchedule();
                            request.setAttribute("PlacementSchedule", PlacementSchedule);
                            click = "PLACEMENT SCHEDULE";
                            request.setAttribute("click", click);
                            RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                            rd.forward(request, response);
                        }
                        
                        else
                        {
                            err.add("Successfully ADDED to the  Schedule!!");
                            ArrayList[] PlacementSchedule = (ArrayList[]) m.getSchedule();
                            request.setAttribute("PlacementSchedule", PlacementSchedule);
                            click = "PLACEMENT SCHEDULE";
                            request.setAttribute("click", click);
                            RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                            rd.forward(request, response);
                        }
                        
                    }
                    
                    
                    
                    
                    
                    else
                    {
                       err.add("YOU didn't check the check box!");
                        ArrayList[] PlacementSchedule = (ArrayList[]) m.getSchedule();
                        request.setAttribute("PlacementSchedule", PlacementSchedule);
                        click = "PLACEMENT SCHEDULE";
                        request.setAttribute("click", click);
                        RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                        rd.forward(request, response);
                    }
            }
            
            
            
            if (str.equals("EDIT UPDATES")) {

                ArrayList Updates = (ArrayList) m.getUpdates();
                request.setAttribute("Updates", Updates);
                click = "EDIT UPDATES";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            if(changeupdate.equals("DELETE"))
            {
                
                String[] Deletions= request.getParameterValues("deleteupdate");
                
                if(Deletions!=null)
                {
                    
                    for (int i = 0; i < Deletions.length; i++)
                    {
                        
                        String[] temp = Deletions[i].split(",");
                        
                        String Update= temp[0];                      
                        
                       
                        //out.println(rno+","+Name+","+Sector);
                        m.deleteUpdate(Update);
                    }
                }
                
                err.add("Successfully Deleted the Selected Updates!!");
                ArrayList Updates = (ArrayList) m.getUpdates();
                request.setAttribute("Updates", Updates);
                click = "EDIT UPDATES";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            
            
            if(changeupdate.equals("ADD"))
            {
                    String addupdate= request.getParameter("addupdate");
                    
                    if(addupdate!=null)
                    {
                    
                        String update= request.getParameter("updatetext");
                       
                        
                        
                        if(update.equals(""))
                        {
                            err.add("GIVE Update Text!!");
                        }
                        
                        
                        
                        if(err.isEmpty())
                        {
                            boolean there=m.isDerAnyUpdate(update);
                            
                            if(there)
                            {
                                err.add("THIS Update Already exists!!");
                            }
                            
                            else
                            {
                               boolean added= m.insertIntoUpdates(update);
                               
                               if(!added)
                               {
                                   err.add("Adding Failed!!");
                               }
                            }
                            
                        }
                        
                        
                        if(!err.isEmpty())
                        {
                            
                            ArrayList Updates = (ArrayList) m.getUpdates();
                            request.setAttribute("Updates", Updates);
                            click = "EDIT UPDATES";
                            request.setAttribute("click", click);
                            RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                            rd.forward(request, response);
                        }
                        
                        else
                        {
                            err.add("Update Successfully ADDED!!");
                            ArrayList Updates = (ArrayList) m.getUpdates();
                            request.setAttribute("Updates", Updates);
                            click = "EDIT UPDATES";
                            request.setAttribute("click", click);
                            RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                            rd.forward(request, response);
                        }
                        
                    }
                    
                    
                    else
                    {
                            err.add("YOU didn't check the check box!");
                            ArrayList Updates = (ArrayList) m.getUpdates();
                            request.setAttribute("Updates", Updates);
                            click = "EDIT UPDATES";
                            request.setAttribute("click", click);
                            RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                            rd.forward(request, response);
                    }
            
            }
            
            
            
            if (str.equals("PLACEMENT STATISTICS")) {

                ArrayList[] PlacementStatics = m.getPlacementTable();
                request.setAttribute("PlacementStatics", PlacementStatics);
                click = "PLACEMENT STATISTICS";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            
            if (str.equals("ADD PRIVILEGES")) {

                //ArrayList[] PlacementStatics = m.getPlacementTable();
                //request.setAttribute("PlacementStatics", PlacementStatics);
                click = "ADD PRIVILEGES";
                request.setAttribute("click", click);
                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                rd.forward(request, response);
            }
            
            
            if(privileges.equals("SUBMIT"))
            {
                String[] additions = request.getParameterValues("additions");
                
                if(additions!=null)
                {
                    String loginid= request.getParameter("adminlogin");
                    String password= request.getParameter("adminpassword");
                    String PRRoll = request.getParameter("prroll");
                    
                     for(int i=0;i<additions.length;i++ )
                     {
                         if(additions[i].equals("ADD ADMIN"))
                         {
                             
                             
                             if(loginid.equals("")||password.equals(""))
                             {
                                 err.add("PLEASE GIVE ADMIN USER ID OR PASSWORD!");
                             }
                             
                             else 
                             {  
                                 if (m.isAdminIdAlreadyExists(loginid)) 
                                 {
                                     err.add("CHOOSEN ADMIN ID ALREADY EXISTS! PLEASE CHOOSE ANOTHER ID");
                                 } 
                                 else 
                                 {
                                     m.insertIntoPriviles(loginid, password, "admin");
                                     err.add("NEW ADMIN SUUCESSFULLY ADDED!");
                                 }

                             }
                         }
                         
                         
                         
                         
                         if(additions[i].equals("REPLACE PR"))
                         {                             
                             
                             
                             
                             if(PRRoll.equals(""))
                             {
                                 err.add("ENTER ROLL NUMBER OF THE STUDENT WHO WILL BE THE PR!");
                             }
                             
                             else 
                             {
                                 String pwd=m.isThisStudentExists(PRRoll);
                                 if(pwd.equals(""))
                                 {
                                     err.add("THIS STUDENT DOES NOT EXISTS");
                                 }
                             
                                 else
                                 {
                                     m.replacePR(PRRoll,pwd,"PR");
                                     err.add("PR SUUCESSFULLY REPLACED!");
                                 }
                             
                             
                             }
                         }
                         
                         
                         
                     }
                     
                     if (!err.isEmpty()) 
                     {
                        click = "ADD PRIVILEGES";
                        request.setAttribute("click", click);
                        RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                        rd.forward(request, response);
                    }
                     else
                     {
                         click = "ADD PRIVILEGES";
                        request.setAttribute("click", click);
                        RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                        rd.forward(request, response);
                     }
                }
                
                
                else
                {
                    err.add("YOU FORGOT TO CHECK SOME CHECKBOXES :(");
                    click = "ADD PRIVILEGES";
                    request.setAttribute("click", click);
                    RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                    rd.forward(request, response);
                }
               
            }
            
            
            if(privileges.equals("GO BACK"))
            {
                    click = "HOME";
                    request.setAttribute("click", click);
                    RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                    rd.forward(request, response);
            }
            
            
            
            if (str.equals("LOG OUT")) {
                RequestDispatcher rd = request.getRequestDispatcher("LOG_OUT");
                rd.forward(request, response);
            }
        } finally {            
            out.close();
        }
    }

   
}
