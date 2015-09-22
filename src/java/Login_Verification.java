/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Login_Verification extends HttpServlet {
    private HttpSession HttpSession;

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            
            String str=request.getParameter("login");
            
            
            
            if(str.equals("   LOGIN   "))
            {
                String type = request.getParameter("ltype");
                String uid = request.getParameter("uid");
                String password = request.getParameter("pwd");

                String click = "HOME";
                request.setAttribute("click", click);


                ArrayList err = new ArrayList();
                request.setAttribute("err", err);

                HttpSession session = request.getSession();

                MyDB m = new MyDB();

                if (type.equals("student")) {
                    int rno = m.isStudentUseridAndPasswordMatch(uid, password);
                    if (rno != -1) {
                        session.setAttribute("rno", rno);
                        session.setAttribute("webmail", uid);
                        RequestDispatcher rd = request.getRequestDispatcher("Stud_Home");
                        rd.forward(request, response);
                    } else {

                        err.add("USER ID OR PASSWORD MISMATCH");
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                }

                if (type.equals("company")) {
                    if (m.isCompanyUseridAndPasswordMatch(uid, password)) {
                        session.setAttribute("loginid", uid);
                        RequestDispatcher rd = request.getRequestDispatcher("Company_Home");
                        rd.forward(request, response);
                    } else {
                        err.add("USER ID OR PASSWORD MISMATCH");
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                }
                if (type.equals("pr")) {
                    if (m.isPrUseridAndPasswordMatch(uid, password)) {
                        int rno = m.isStudentUseridAndPasswordMatch(uid, password);
                        session.setAttribute("rno", rno);
                        session.setAttribute("webmail", uid);
                        RequestDispatcher rd = request.getRequestDispatcher("PR_Home");
                        rd.forward(request, response);
                    } else {
                        err.add("USER ID OR PASSWORD MISMATCH");
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                }
                if (type.equals("admin")) {
                    if (m.isAdminUseridAndPasswordMatch(uid, password)) {
                        session.setAttribute("loginid", uid);
                        RequestDispatcher rd = request.getRequestDispatcher("Admin_Home");
                        rd.forward(request, response);
                    } else {
                        err.add("USER ID OR PASSWORD MISMATCH");
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                }

            
            
           }  
            
            
            else
            {
                
            }
            
        } finally {            
            out.close();
        }
   
    }
}
