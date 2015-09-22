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

/**
 *
 * @author V.BhargavaMourya
 */
public class Company_Registration_Verification extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            
            ArrayList err=new ArrayList();
            ArrayList adding=new ArrayList();
            
            if(request.getParameter("button").equals("REGISTER"))
            {
                MyDB m=new MyDB();
                if(m.isDerAnySameCompanyID(request.getParameter("loginid").trim()))
                {
                    err.add("<h3><B></B>LOGIN ID ALREADY TAKEN PLEASE CHOOSE ANOTHER</h3>");
                }
                else
                {
                    adding.add(request.getParameter("loginid"));
                }
                
                if(!(request.getParameter("password").equals(request.getParameter("confpassword"))))
                {
                    err.add("LOGIN PASSWORD AND CONFIRM LOGIN PASSWORD MISMATCHED");
                }
                else
                {
                    adding.add(request.getParameter("password"));
                }
                
                if(request.getParameter("cname")=="")
                {
                    err.add("COMPANY NAME CANNOT BE LEFT BLANK");
                }
                else
                {
                    adding.add(request.getParameter("cname"));
                }
                
                adding.add(request.getParameter("type"));
                adding.add(request.getParameter("sector"));
                
                
                if(request.getParameter("website")=="")
                {
                    err.add("PLEASE GIVE COMPANY'S WEBSITE");
                }
                else
                {
                    adding.add(request.getParameter("website"));
                }
                
                if(request.getParameter("location")=="")
                {
                    err.add("PLEASE FILL THE LOCATION");
                }
                else
                {
                    adding.add(request.getParameter("location"));
                }
                
                if(request.getParameter("ctc")=="")
                {
                    err.add("PLEASE MENTION CTC");
                }
                                
                else
                {                   
                        adding.add(request.getParameter("ctc"));
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
                        temp=temp+","+depts[i];
                    }
                    adding.add(temp);
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
                            adding.add(request.getParameter("cpi"));
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
                   adding.add(request.getParameter("name"));
                }
                
                if(request.getParameter("designation")=="")
                {
                    err.add("DESIGNATION CANNOT BE LEFT BLANK");
                }
                else
                {
                   adding.add(request.getParameter("designation"));
                }
                
                if(request.getParameter("email")=="")
                {
                    err.add("EMAIL CANNOT BE LEFT BLANK");
                }
                else
                {
                   adding.add(request.getParameter("email"));
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
                
                         adding.add(request.getParameter("mobile"));
                
                    }
                    catch(Exception e)
                    {
                        err.add("MOBILE NUMBER should be Numeric");
                    }
                }
                
                
                
                if(!err.isEmpty())
                {
                    adding.clear();
                    request.setAttribute("err", err);
                    RequestDispatcher rd=request.getRequestDispatcher("Company_Registration_Page");
                    rd.forward(request, response);
                }
                
                else
                {
                    if(m.addNewCompany(adding))
                    {
                        err.add("<h2><B>registration Successful..GO BACK AND LOGIN</B></h2>");
                    }
                    else
                    {
                         //err.add(adding);
                         err.add("<h2>You Have Already Registered</h2>");
                    }
                    request.setAttribute("err", err);
                    RequestDispatcher rd=request.getRequestDispatcher("Company_Registration_Page");
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
