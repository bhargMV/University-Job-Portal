/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Company;

import Common.MyDB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author V.BhargavaMourya
 */
public class Upload_Company_Details extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession session= request.getSession(false);
        MyDB m = new MyDB();
         ArrayList err=new ArrayList();
        request.setAttribute("err", err);
        response.setHeader( "Pragma", "no-cache" );
        response.setHeader( "Cache-Control", "no-cache" );
        response.setDateHeader( "Expires", 0 );
        try {
            ArrayList storing=new ArrayList();
            
            File file;
            int maxFileSize = 15000 * 1024;
            int maxMemSize = 15000 * 1024;
            ServletContext context = request.getServletContext();
            String filePath = context.getInitParameter("company-file-upload");
            String tempPath = context.getInitParameter("temp-file-upload");
            
            filePath=filePath+(String)session.getAttribute("loginid")+"\\";
            
            File path = new File(filePath);
	                        if (!path.exists()) {
	                            boolean status = path.mkdirs();
	                        }
	 
            //out.println(filePath);
            // Verify the content type
            String contentType = request.getContentType();
            if ((contentType.indexOf("multipart/form-data") >= 0)) {

                DiskFileItemFactory factory = new DiskFileItemFactory();
                // maximum size that will be stored in memory
                factory.setSizeThreshold(maxMemSize);
                // Location to save data that is larger than maxMemSize.
                factory.setRepository(new File(tempPath));

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                // maximum file size to be uploaded.
                upload.setSizeMax(maxFileSize);
                try {
                    // Parse the request to get file items.
                    List fileItems = upload.parseRequest(request);

                    // Process the uploaded file items
                    Iterator i = fileItems.iterator();

                   
                    while (i.hasNext()) {
                        FileItem fi = (FileItem) i.next();
                        if (fi.getName()!="" && fi!=null && !fi.isFormField()) {
                            // Get the uploaded file parameters
                            String fieldName = fi.getFieldName();
                            String fileName = fi.getName();
                            boolean isInMemory = fi.isInMemory();
                            long sizeInBytes = fi.getSize();
                            // Write the file
                            if (fileName.lastIndexOf("\\") >= 0) {
                                file = new File(filePath
                                        + fileName.substring(fileName.lastIndexOf("\\")));
                            } else {
                                file = new File(filePath
                                        + fileName.substring(fileName.lastIndexOf("\\") + 1));
                            }
                            if(file!=null)
                            fi.write(file);
                            
                             storing.add(fileName);
                            
                        }
                        
                        else{
                            storing.add("-");
                        }
                    }
                     m.addDetailsOfCompany((String)session.getAttribute("loginid"),storing);
                    //out.println(storing);
               
                } catch (Exception ex) {
                    out.println(ex);
                }
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>No file uploaded</p>");
                out.println("</body>");
                out.println("</html>");
            } 
                err.add("UPLOADED SUCCESSFULLY");
                String click="HOME";
                request.setAttribute("click", click);
                RequestDispatcher rd=request.getRequestDispatcher("Company_Home");
                rd.forward(request, response); 
        } finally {            
            out.close();
        }
    }

    
}
