/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author V.BhargavaMourya
 */
public class Registration_Page_Redirect extends HttpServlet {

    
  
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
           String type=request.getParameter("rtype");
          
          
           if(type.equals("student"))
           {
               RequestDispatcher rd = request.getRequestDispatcher("Student_Registration_Page");
               rd.forward(request,response);
              
           }
           else
           {
               RequestDispatcher rd=request.getRequestDispatcher("Company_Registration_Page");
               rd.forward(request, response);
           } 
        } finally {            
            out.close();
        }
    }

    
}
