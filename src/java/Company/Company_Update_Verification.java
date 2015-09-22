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
public class Company_Update_Verification extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            ArrayList err=new ArrayList();
            ArrayList updating=new ArrayList();
            HttpSession session= request.getSession(false);
            
            if(request.getParameter("button").equals("UPDATE"))
            {
                MyDB m=new MyDB();
                
                updating.add(((String)session.getAttribute("loginid")).trim());
                
                //out.println( request.getParameter("oldpassword"));
                
                
                String ChangePassword=request.getParameter("change");
                
                if(ChangePassword==null)
                {
                    updating.add((String)request.getParameter("pwd"));
                }
                
                else
                {
                    boolean success = m.isCompanyUseridAndPasswordMatch(request.getParameter("loginid"), request.getParameter("oldpassword"));

                    if (!success) 
                    {
                        ArrayList RegisteredCompanyInfoForUpdating = m.getRegisteredCompanyInfoForUpdating((String) session.getAttribute("loginid"));
                        request.setAttribute("RegisteredCompanyInfoForUpdating", RegisteredCompanyInfoForUpdating);
                        err.add("OLD PASSWORD MISMATCH FOR THIS LOGIN ID");
                        updating.clear();
                        request.setAttribute("err", err);
                        RequestDispatcher rd = request.getRequestDispatcher("Company_Update_Details");
                        rd.forward(request, response);
                    }
                    if (request.getParameter("newpassword") == "")
                    {
                        err.add("CHOOSE SOME NEW PASSWORD");
                    } 
                    else 
                    {
                        updating.add(request.getParameter("newpassword"));
                    }
                }
                
                if(request.getParameter("cname")=="")
                {
                    err.add("COMPANY NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                    updating.add(request.getParameter("cname"));
                }
                
                updating.add(request.getParameter("type"));
                updating.add(request.getParameter("sector"));
                
                
                if(request.getParameter("website")=="")
                {
                    err.add("PLEASE GIVE COMPANY'S WEBSITE");
                }
                else
                {
                    updating.add(request.getParameter("website"));
                }
                
                if(request.getParameter("location")=="")
                {
                    err.add("PLEASE FILL THE LOCATION");
                }
                else
                {
                    updating.add(request.getParameter("location"));
                }
                
                if(request.getParameter("ctc")=="")
                {
                    err.add("PLEASE MENTION CTC");
                }
                                
                else
                {                   
                        updating.add(request.getParameter("ctc"));
                }
                
                String[] depts=request.getParameterValues("departments");
                
                if(depts==null)
                {
                    err.add("PLEASE SELECT ELIGIBLE DEPARTMENTS");
                }
                else
                {   
                    String temp="";
                    for(int i=0;i<depts.length;i++)
                    {   
                        if(temp=="")
                        {
                            temp=temp+depts[i];
                        }
                        else
                        {
                            temp=temp+","+depts[i];
                        }
                        
                    }
                    updating.add(temp);
                }
                
                if(request.getParameter("cpi")=="")
                {
                    err.add("PLEASE MENTION MINIMUM CPI FOR ELIGIBILITY");
                }
                
                if(request.getParameter("cpi")!="")
                {
                    try
                    {
                        double i=Double.parseDouble(request.getParameter("cpi"));
                        if(i>10)
                        {
                            err.add("CPI SHOULD BE LESS THAN OR EQUAL TO 10");
                        }
                        else
                        {
                            updating.add(request.getParameter("cpi"));
                        }
                    }
                    catch(Exception e)
                    {
                        err.add("CPI should be Numeric");
                    }
                }
                
                if(request.getParameter("name")=="")
                {
                    err.add("CONTACT NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                   updating.add(request.getParameter("name"));
                }
                
                if(request.getParameter("designation")=="")
                {
                    err.add("DESIGNATION CANNOT BE LEFT BLANK");
                }
                else
                {
                   updating.add(request.getParameter("designation"));
                }
                
                if(request.getParameter("email")=="")
                {
                    err.add("EMAIL CANNOT BE LEFT BLANK");
                }
                else
                {
                   updating.add(request.getParameter("email"));
                }
                
                if(request.getParameter("mobile")=="")
                {
                    err.add("MOBILE NUMBER CANNOT BE LEFT BLANK");
                }
                
                if(request.getParameter("mobile")!="")
                {
                    try
                    {
                        int i=Integer.parseInt(request.getParameter("mobile"));                   
                
                         updating.add(request.getParameter("mobile"));
                
                    }
                    catch(Exception e)
                    {
                        err.add("MOBILE NUMBER should be Numeric");
                    }
                }
                
                
               //out.println(updating);
               if(!err.isEmpty())
                {
                    ArrayList RegisteredCompanyInfoForUpdating=m.getRegisteredCompanyInfoForUpdating((String)session.getAttribute("loginid"));
                    request.setAttribute("RegisteredCompanyInfoForUpdating",RegisteredCompanyInfoForUpdating);
                    updating.clear();
                    request.setAttribute("err", err);
                    RequestDispatcher rd=request.getRequestDispatcher("Company_Update_Details");
                    rd.forward(request, response);
                }
                
                else
                {
                    if(m.UpdateCompanyDetails(((String)session.getAttribute("loginid")).trim(),updating))
                    {
                        err.add("UPDATED SUCCESSFULLY!!");
                        request.setAttribute("err", err);
                        String click;
                        click="HOME";
                        request.setAttribute("click", click);
                        RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                        rd.forward(request, response);
                    }
                    else
                    {
                         //err.add(updating);
                        ArrayList RegisteredCompanyInfoForUpdating=m.getRegisteredCompanyInfoForUpdating((String)session.getAttribute("loginid"));
                        request.setAttribute("RegisteredCompanyInfoForUpdating",RegisteredCompanyInfoForUpdating);
                        err.add("<h2>UPDATE FAILED</h2>");
                    }
                    request.setAttribute("err", err);
                    RequestDispatcher rd=request.getRequestDispatcher("Company_Update_Details");
                    rd.forward(request, response);
                 }
                 
            }
            else
            {
                String click;
                click="HOME";
                request.setAttribute("click", click);
               RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
              rd.forward(request, response);
            }
        } finally {            
            out.close();
        }
    }

  
}
