/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author V.BhargavaMourya
 */
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;


public class MyDB {
    
               String url = "jdbc:mysql://127.0.0.1/";
               String dbName = "Placement_Portal";
	       String driver = "com.mysql.jdbc.Driver";
	       String userName = "root"; 
	       String passwd = "";
               
               public ArrayList getUpdates()
               {
                   ArrayList arr=new ArrayList();
                   String query="SELECT * FROM Updates;";
                   
                   try
                   {
                        Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
			Statement stmt=null;
			ResultSet rs = null;			
			stmt=conn.createStatement();
			rs= stmt.executeQuery(query);
                        
                        while(rs.next())
                        {
                            arr.add(rs.getString("Content"));
                        }
                        stmt.close();
			conn.close();
                       
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
                   
                   return arr;
               }
               
               public ArrayList[] getPlacementTable() 
               {
                   ArrayList[] SelectedStudents = new ArrayList[7];

                   for (int i = 0; i < 7; i++) {
                       SelectedStudents[i] = new ArrayList();
                   }

                   

                   String query = "SELECT * FROM placed;";

                   try {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;

                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                       rs = prest.executeQuery();

                       int i = 0;
                       while (rs.next()) {
                           int rno = rs.getInt("rno");
                           SelectedStudents[0].add(i, rno);

                           ArrayList details = getDetailsFromCurrentStudents(rno);

                           SelectedStudents[1].add(i, details.get(0));
                           SelectedStudents[2].add(i, details.get(1));
                           SelectedStudents[3].add(i, details.get(2));
                           SelectedStudents[4].add(i, details.get(3));
                           SelectedStudents[5].add(i, rs.getString("company"));
                           SelectedStudents[6].add(i, rs.getString("sector"));
                           i++;
                       }

                       conn.close();
                       stmt.close();
                       prest.close();

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   
                   return SelectedStudents;

            }
               
               
               
               public boolean isDerAnySameCompanyID(String id)
               {
                    String query="SELECT * FROM companies;";
                    
                    try
                    {
                        Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
			Statement stmt=null;
			ResultSet rs = null;			
			stmt=conn.createStatement();
			rs= stmt.executeQuery(query);
                        
                        while(rs.next())
                        {
                            if(rs.getString("id").equals(id))
                            {
                                return true;
                            }
                        }
                        
                        stmt.close();
                        conn.close();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                   
                   return false;
               }
               
               
               
               public boolean addNewCompany(ArrayList adding)
               {
                   try
                   {
                         Class.forName(driver).newInstance();
                         Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
                         Connection conn1 = DriverManager.getConnection(url+dbName,userName,passwd);
                         
                         String query="INSERT INTO companies VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?,?,?,?);";
                         PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                         
                        prest.setString(1,(String)adding.get(0));
			prest.setString(2,(String)adding.get(1));
        		prest.setString(3,(String)adding.get(2));
			prest.setString(4,(String)adding.get(3));
                        prest.setString(5,(String)adding.get(4));
                        prest.setString(6,(String)adding.get(5));
			prest.setString(7,(String)adding.get(6));
                        prest.setString(8,(String)adding.get(7));
                        prest.setString(9,(String)adding.get(8));
                        prest.setFloat(10,Float.parseFloat((String)adding.get(9)));
        		prest.setString(11,(String)adding.get(10));
			prest.setString(12,(String)adding.get(11));
                        prest.setString(13,(String)adding.get(12));
                        prest.setInt(14,Integer.parseInt((String)adding.get(13)));
                        prest.setString(15,"-");
                        
                        int cnt = prest.executeUpdate();
                        
                       		
                        
                        Statement stmt=null;
			ResultSet rs = null;
                        
			
                        stmt=conn1.createStatement();
			rs= stmt.executeQuery("SELECT * FROM companies;");
                        
                        while(rs.next())
                        {
                            if(rs.getString(1).equals((String)adding.get(0)))
                            {
                                return true;
                            }
                        }
                        
                     
                        conn.close();
                        stmt.close();
                        prest.close();
                        
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
                       
                   return false;
               }
               
               
               
               public boolean addNewStudent(ArrayList adding)
               {
                   try
                   {
                         Class.forName(driver).newInstance();
                         Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
                         Connection conn1 = DriverManager.getConnection(url+dbName,userName,passwd);
                         
                         String query="INSERT INTO students_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
                         PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                         
                        prest.setInt(1,(Integer)adding.get(0));
			prest.setString(2,(String)adding.get(1));
        		prest.setString(3,(String)adding.get(2));
			prest.setString(4,(String)adding.get(3));
                        prest.setString(5,(String)adding.get(4));
                        prest.setString(6,(String)adding.get(5));
			prest.setString(7,(String)adding.get(6));
                        prest.setString(8,(String)adding.get(7));
                        prest.setFloat(9,(Float)adding.get(8));
        		prest.setFloat(10,(Float)adding.get(9));
			 prest.setString(11,"-");
                   
                        int cnt = prest.executeUpdate();
                        
                       		
                        
                        Statement stmt=null;
			ResultSet rs = null;
                        
			
                        stmt=conn1.createStatement();
			rs= stmt.executeQuery("SELECT * FROM students_info;");
                        
                        while(rs.next())
                        {
                            if(rs.getInt("roll")==(Integer)adding.get(0))
                            {
                                return true;
                            }
                        }
                        
                     
                        conn.close();
                        stmt.close();
                        prest.close();
                        
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
                       
                   return false;
               }
               
               
               
               public int isStudentUseridAndPasswordMatch(String uid,String password)
               {
                   String query = "SELECT * FROM current_students WHERE webmail=? and password=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setString(1,uid);
                       prest.setString(2,password);

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {
                           if(isStudentRegistered(rs.getInt("rno")))
                           {    
                                return rs.getInt("rno");
                           }
                       }
                       conn.close();
                       stmt.close();
                       prest.close();

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return -1;
               }
               
               
               
               public boolean isStudentRegistered(int rno)
               {
                   String query = "SELECT * FROM students_info WHERE roll=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setInt(1, rno);                      

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {                      
                               return true;
                       }
                       conn.close();
                       stmt.close();
                       prest.close();

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return false;
               }
               
               
               
                public boolean isCompanyUseridAndPasswordMatch(String uid,String password)
               {
                   String query = "SELECT * FROM companies WHERE id=? and password=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setString(1,uid);
                       prest.setString(2,password);

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {
                          return true;
                       }


                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return false;
               }
                
                
                
                
                 public boolean isPrUseridAndPasswordMatch(String uid,String password)
               {
                   String query = "SELECT * FROM privileges WHERE id=? and password=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setString(1,uid);
                       prest.setString(2,password);

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {
                          if(rs.getString("type").equals("PR"))
                          return true;
                       }


                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return false;
               }
                 
                 
                 
                  public boolean isAdminUseridAndPasswordMatch(String uid,String password)
               {
                   String query = "SELECT * FROM privileges WHERE id=? and password=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setString(1,uid);
                       prest.setString(2,password);

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {
                          if(rs.getString("type").equals("admin")) 
                          return true;
                       }


                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return false;
               }
               
               public int isStudentACurrentStudent(String webmail,String password)
               {
                   String query = "SELECT * FROM current_students WHERE webmail=? and password=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setString(1,webmail); 
                       prest.setString(2,password);

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {                      
                               return rs.getInt("rno");
                       }
                       conn.close();
                       stmt.close();
                       prest.close();

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return -1;
               }
               
               
               public ArrayList[] getCompanies()
               {
                   ArrayList[] Companies=new ArrayList[14];
                   
                   for(int i=0;i<14;i++)
                   {
                       Companies[i]=new ArrayList();
                   }
                   
                   String query = "SELECT * FROM companies;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;
                       stmt=conn.createStatement();
		       rs= stmt.executeQuery(query);

                       
                       while(rs.next()) 
                       {                      
                               Companies[0].add(rs.getString("Name"));
                               Companies[1].add(rs.getString("type"));
                               Companies[2].add(rs.getString("sector"));
                               Companies[3].add(rs.getString("website"));
                               Companies[4].add(rs.getString("location"));
                               Companies[5].add(rs.getFloat("ctc"));
                               Companies[6].add(rs.getString("departments"));
                               Companies[7].add(rs.getFloat("cpi"));
                               Companies[8].add(rs.getString("id"));
                               Companies[9].add(rs.getString("details"));
                               Companies[10].add(rs.getString("contactname"));
                               Companies[11].add(rs.getString("designation"));
                               Companies[12].add(rs.getString("email"));
                               Companies[13].add(rs.getString("mobile"));
                       }
                       conn.close();
                       stmt.close();
                       

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   
                   return Companies;
               }
               
               
               
               
               public ArrayList[] getSchedule()
               {
                   ArrayList[] Schedule=new ArrayList[6];
                   
                   for(int i=0;i<6;i++)
                   {
                       Schedule[i]=new ArrayList();
                   }
                   
                   String query = "SELECT * FROM schedule order by day;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;
                       stmt=conn.createStatement();
		       rs= stmt.executeQuery(query);

                       
                       while(rs.next()) 
                       {                      
                               Schedule[0].add(rs.getString("company"));
                               Schedule[1].add(rs.getString("sector"));
                               Schedule[2].add(rs.getString("writtentest"));
                               Schedule[3].add(rs.getString("timeslot"));
                               Schedule[4].add(rs.getString("venue"));
                               Schedule[5].add(rs.getInt("day"));
                            
                       }
                       conn.close();
                       stmt.close();
                       

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   
                   return Schedule;
               }
               
               
               

                public ArrayList[] getEligibleCompanies(int rno, String webmail) 
                {
                      ArrayList[] EligibleCompanies=new ArrayList[7];
                      
                      for(int i=0;i<7;i++)
                      {
                            EligibleCompanies[i]=new ArrayList();
                      }
                      
                      
                      if(!isThisStudentGotPlaced(rno))
                      {
                          ArrayList[] Companies = getCompanies();

                          //EligibleCompanies=Companies;

                          ArrayList DeptAndCPI = getDeptAndCPI(rno);

                          String Dept = (String) DeptAndCPI.get(0);
                          Float CPI = (Float) DeptAndCPI.get(1);

                          Iterator it1 = Companies[0].iterator();
                          Iterator it2 = Companies[1].iterator();
                          Iterator it3 = Companies[2].iterator();
                          Iterator it4 = Companies[3].iterator();
                          Iterator it5 = Companies[4].iterator();
                          Iterator it6 = Companies[5].iterator();
                          Iterator it7 = Companies[6].iterator();
                          Iterator it8 = Companies[7].iterator();
                          Iterator it9 = Companies[8].iterator();

                          while (it1.hasNext()) {
                              String Name = (String) it1.next();
                              String Type = (String) it2.next();
                              String Sector = (String) it3.next();
                              String Website = (String) it4.next();
                              String Location = (String) it5.next();
                              Float CTC = (Float) it6.next();
                              String[] EligibleDepts = ((String) it7.next()).split(",");
                              float EligibleCPI = (Float) it8.next();
                              String Id = (String) it9.next();

                              boolean check = isHeAlreadyApplied(rno, Name, Sector);

                              if (!check) {
                                  for (int i = 0; i < EligibleDepts.length; i++) {
                                      if ((EligibleDepts[i].equals("ALL") || EligibleDepts[i].equals(Dept)) && CPI >= EligibleCPI) {
                                          EligibleCompanies[0].add(Name);
                                          EligibleCompanies[1].add(Type);
                                          EligibleCompanies[2].add(Sector);
                                          EligibleCompanies[3].add(Website);
                                          EligibleCompanies[4].add(Location);
                                          EligibleCompanies[5].add(CTC);
                                          EligibleCompanies[6].add(Id);
                                          break;
                                      }
                                  }

                              }
                          }
                      }  
                       
                      return EligibleCompanies;
                }
                
                
                public boolean isThisStudentGotPlaced(int rno)
                {
                   String query = "SELECT * FROM placed WHERE rno=? ";

                    try 
                    {
                        Class.forName(driver).newInstance();
                        Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                        Statement stmt = null;
                        ResultSet rs = null;


                        PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                        prest.setInt(1, rno);
                      

                        rs = prest.executeQuery();

                        if (rs.next()) {
                            return true;
                        }
                        conn.close();
                        stmt.close();
                        prest.close();

                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                    return false;
                }
                
                
                
                
                public ArrayList getDeptAndCPI(int rno)
                {
                    ArrayList result= new ArrayList();
                    
                    String query = "SELECT * FROM current_students WHERE rno=?";
                    try 
                    {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setInt(1,rno); 
                       

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {                      
                               result.add(rs.getString("dept"));
                               result.add(rs.getFloat("cpi"));
                       }
                       conn.close();
                       stmt.close();
                       prest.close();

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                    
                    return result;
                }
                
                
                
                

            public boolean isHeAlreadyApplied(int rno, String CompanyName, String Sector) 
            {
        
             String query = "SELECT * FROM apply WHERE rno=? and company=? and sector=?";
             
            try 
            {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;


                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                prest.setInt(1, rno);
                prest.setString(2, CompanyName);
                prest.setString(3, Sector);


                rs = prest.executeQuery();

            if (rs.next()) 
            {
                return true;
            }
            conn.close();
            stmt.close();
            prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
                return false;
         }

            
            
         public ArrayList[] getAppliedCompanies(int rno) 
         {
             ArrayList[] AppliedCompanies = new ArrayList[3];

             for (int i = 0; i < 3; i++)
             {
                 AppliedCompanies[i] = new ArrayList();
             }
             
             
             String query = "SELECT * FROM apply WHERE rno=? ";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;


                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                prest.setInt(1, rno);
                


                rs = prest.executeQuery();

                 while(rs.next()) 
                 {
                     AppliedCompanies[0].add(rs.getString("company"));
                     AppliedCompanies[1].add(rs.getString("sector"));
                     AppliedCompanies[2].add(rs.getString("cv"));
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             return AppliedCompanies;
        }
         
         

        public void insertIntoApply(int rno, String Name, String Sector,String cv) 
        {
        
            String query = "INSERT INTO apply values(?,?,?,?); ";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                


                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                prest.setInt(1, rno);
                prest.setString(2,Name);
                prest.setString(3,Sector);
                prest.setString(4,cv);

                int rs = prest.executeUpdate();

                 
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
        }

        
        
        
        public ArrayList[] getAllAppliedStudents() 
        {
             ArrayList[] AppliedStudents = new ArrayList[8];

             for (int i = 0; i < 8; i++)
             {
                 AppliedStudents[i] = new ArrayList();
             }
             
             
             String query = "SELECT * FROM apply";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;


                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                rs = prest.executeQuery();

                 while(rs.next()) 
                 {
                     int rno=rs.getInt("rno");
                     AppliedStudents[0].add(rno);
                     
                     ArrayList details=getDetailsFromCurrentStudents(rno);
                     
                     AppliedStudents[1].add(details.get(0));
                     AppliedStudents[2].add(details.get(1));
                     AppliedStudents[3].add(details.get(2));
                     AppliedStudents[4].add(details.get(3));
                     AppliedStudents[5].add(rs.getString("company"));
                     AppliedStudents[6].add(rs.getString("sector"));
                     AppliedStudents[7].add(rs.getString("cv"));
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             return AppliedStudents;
        }
        
        

        public ArrayList getDetailsFromCurrentStudents(int rno)
        {
            ArrayList details=new ArrayList();
            
            String query = "SELECT * FROM current_students WHERE rno=?";
           
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setInt(1, rno);
                
                rs = prest.executeQuery();

                 while(rs.next()) 
                 {
                    details.add(rs.getString("name"));
                    details.add(rs.getString("webmail")); 
                    details.add(rs.getString("programme"));
                    details.add(rs.getString("dept"));      
                    details.add(rs.getFloat("cpi"));
                 }
                 
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            return details;
        }

        
        
        public ArrayList[] getRegisteredStudents()
        {
             ArrayList[] RegisteredStudents = new ArrayList[14];

             for (int i = 0; i < 14; i++)
             {
                 RegisteredStudents[i] = new ArrayList();
             }
             
             String query = "select * FROM students_info;";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

 
                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                rs = prest.executeQuery();

                 while(rs.next()) 
                 {
                     int rno=rs.getInt("roll");
                     RegisteredStudents[0].add(rno);
                     
                     ArrayList details=getDetailsFromCurrentStudents(rno);
                     
                     RegisteredStudents[1].add(details.get(0));
                     RegisteredStudents[2].add(details.get(1));
                     RegisteredStudents[3].add(details.get(2));
                     RegisteredStudents[4].add(details.get(3));
                     RegisteredStudents[5].add(details.get(4));
                     RegisteredStudents[6].add(rs.getString("gender"));
                     RegisteredStudents[7].add(rs.getString("dob"));
                     RegisteredStudents[8].add(rs.getString("present"));
                     RegisteredStudents[9].add(rs.getString("email"));
                     RegisteredStudents[10].add(rs.getFloat("tenth"));
                     RegisteredStudents[11].add(rs.getFloat("twelth"));
                     RegisteredStudents[12].add(rs.getString("cv1"));
                     RegisteredStudents[13].add(rs.getString("cv2"));
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             return RegisteredStudents;
            
        }
        
        
        
        public ArrayList getRegisteredStudentTotalInfo(int rno)
        {
             ArrayList RegisteredStudentTotalInfo = new ArrayList();

             
             
             String query = "select * FROM students_info WHERE roll=?;";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

 
                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setInt(1, rno);
                
                rs = prest.executeQuery();

                 if(rs.next()) 
                 {
                     
                     RegisteredStudentTotalInfo.add(rno);
                     
                     ArrayList details=getDetailsFromCurrentStudents(rno);
                     
                     RegisteredStudentTotalInfo.add(details.get(0));
                     RegisteredStudentTotalInfo.add(details.get(1));
                     RegisteredStudentTotalInfo.add(details.get(2));
                     RegisteredStudentTotalInfo.add(details.get(3));
                     RegisteredStudentTotalInfo.add(details.get(4));
                     RegisteredStudentTotalInfo.add(rs.getString("gender"));
                     RegisteredStudentTotalInfo.add(rs.getString("dob"));
                     RegisteredStudentTotalInfo.add(rs.getString("present"));
                     RegisteredStudentTotalInfo.add(rs.getString("email"));
                     RegisteredStudentTotalInfo.add(rs.getFloat("tenth"));
                     RegisteredStudentTotalInfo.add(rs.getFloat("twelth"));
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             return RegisteredStudentTotalInfo;
            
        }

        
        
         public ArrayList[] getSelectedStudents(String loginid) 
         {
             ArrayList[] SelectedStudents = new ArrayList[5];

             for (int i = 0; i < 5; i++)
             {
                 SelectedStudents[i] = new ArrayList();
             }
             
             ArrayList CompanyNameAndSector=getCompanyNameAndSector(loginid);
             
             String CompanyName=(String)CompanyNameAndSector.get(0);
             String Sector=(String)CompanyNameAndSector.get(1);
             
             String query = "SELECT * FROM placed WHERE company=? and sector=?;";
           
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setString(1, CompanyName);
                prest.setString(2, Sector);
                
                rs = prest.executeQuery();
                
                int i=0;
                 while(rs.next()) 
                 {
                    int rno=rs.getInt("rno");
                    SelectedStudents[0].add(i,rno);
                    
                    ArrayList details=getDetailsFromCurrentStudents(rno);
                    
                    SelectedStudents[1].add(i,details.get(0));
                    SelectedStudents[2].add(i,details.get(1));
                    SelectedStudents[3].add(i,details.get(2));
                    SelectedStudents[4].add(i,details.get(3));
                    
                    i++;
                 }
                 
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             
             
             
             return SelectedStudents;
         }

         
         
        public ArrayList getCompanyNameAndSector(String loginid) 
        {
            ArrayList CompanyNameAndSector=new ArrayList();
            
            String query = "SELECT * FROM companies WHERE id=?";
           
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setString(1, loginid);
                
                rs = prest.executeQuery();

                 while(rs.next()) 
                 {
                    CompanyNameAndSector.add(rs.getString("Name"));
                    CompanyNameAndSector.add(rs.getString("sector")); 
                    
                 }
                 
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            return CompanyNameAndSector;
        }

        
        
        
        public ArrayList[] getAllAppliedStudents(String loginid)
        {
             ArrayList[] AppliedStudents = new ArrayList[13];

             for (int i = 0; i < 13; i++)
             {
                 AppliedStudents[i] = new ArrayList();
             }
             
             ArrayList CompanyNameAndSector=getCompanyNameAndSector(loginid) ;
             String CompanyName=(String)CompanyNameAndSector.get(0);
             String Sector=(String)CompanyNameAndSector.get(1);
             
             String query = "SELECT * FROM apply WHERE company=? and sector=?;";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;


                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setString(1, CompanyName);
                prest.setString(2, Sector);
                
                rs = prest.executeQuery();
                
                int i=0;
                 while(rs.next()) 
                 {
                     int rno=rs.getInt("rno");
                     String cv= rs.getString("cv");
                     ArrayList RegisteredStudentTotalInfo=getRegisteredStudentTotalInfo(rno);
                     
                    AppliedStudents[0].add(i,rno);                    
                    AppliedStudents[1].add(i,RegisteredStudentTotalInfo.get(1));
                    AppliedStudents[2].add(i,RegisteredStudentTotalInfo.get(2));
                    AppliedStudents[3].add(i,RegisteredStudentTotalInfo.get(3));
                    AppliedStudents[4].add(i,RegisteredStudentTotalInfo.get(4));
                    AppliedStudents[5].add(i,RegisteredStudentTotalInfo.get(5));
                    AppliedStudents[6].add(i,RegisteredStudentTotalInfo.get(6));
                    AppliedStudents[7].add(i,RegisteredStudentTotalInfo.get(7));
                    AppliedStudents[8].add(i,RegisteredStudentTotalInfo.get(8));
                    AppliedStudents[9].add(i,RegisteredStudentTotalInfo.get(9));
                    AppliedStudents[10].add(i,RegisteredStudentTotalInfo.get(10));
                    AppliedStudents[11].add(i,RegisteredStudentTotalInfo.get(11));
                    AppliedStudents[12].add(i,cv); 
                    
                    i++;
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
             return AppliedStudents;
        }
        
        
        
        
        public void insertIntoPlaced(int rno, String CompanyName, String Sector) 
        {
        
            String query = "INSERT INTO placed values(?,?,?); ";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                


                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                prest.setInt(1, rno);
                prest.setString(2,CompanyName);
                prest.setString(3,Sector);

                int rs = prest.executeUpdate();

                 
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
        }

        
        public ArrayList getRegisteredStudentInfoForUpdating(int rno)
        {
            ArrayList RegisteredStudentInfoForUpdating = new ArrayList();

             
             
             String query = "select * FROM students_info WHERE roll=?;";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

 
                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setInt(1, rno);
                
                rs = prest.executeQuery();

                 if(rs.next()) 
                 {
                     
                     RegisteredStudentInfoForUpdating.add(rs.getString("gender"));
                     RegisteredStudentInfoForUpdating.add(rs.getString("dob"));
                     RegisteredStudentInfoForUpdating.add(rs.getString("mother"));
                     RegisteredStudentInfoForUpdating.add(rs.getString("father"));
                     RegisteredStudentInfoForUpdating.add(rs.getString("present"));
                     RegisteredStudentInfoForUpdating.add(rs.getString("permanent"));
                     RegisteredStudentInfoForUpdating.add(rs.getString("email"));
                     RegisteredStudentInfoForUpdating.add(rs.getFloat("tenth"));
                     RegisteredStudentInfoForUpdating.add(rs.getFloat("twelth"));
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             return RegisteredStudentInfoForUpdating;
        }

        
          public boolean UpdateStudentDetails(int rno, ArrayList updating) 
          {
                     try
                     {
                         Class.forName(driver).newInstance();
                         Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
                         Connection conn1 = DriverManager.getConnection(url+dbName,userName,passwd);
                         
                        String query="update students_info set gender=?,dob=?,mother=?,father=?,present=?,permanent=?,email=?,tenth=?,twelth=? where roll=?";
                        //String query="INSERT INTO students_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);";
                         
                        //PreparedStatement preprest = (PreparedStatement) conn.prepareStatement(prequery);
                        PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                         
                        //preprest.setInt(1, rno);
                        
                        
			prest.setString(1,(String)updating.get(0));
        		prest.setString(2,(String)updating.get(1));
			prest.setString(3,(String)updating.get(2));
                        prest.setString(4,(String)updating.get(3));
                        prest.setString(5,(String)updating.get(4));
			prest.setString(6,(String)updating.get(5));
                        prest.setString(7,(String)updating.get(6));
                        prest.setFloat(8,(Float)updating.get(7));
        		prest.setFloat(9,(Float)updating.get(8));
                        prest.setInt(10,rno);
                        //prest.setString(11,"-");
                        //prest.setString(12,"-");
                        
                        //int precnt=preprest.executeUpdate();
                        int cnt = prest.executeUpdate();
                        
                        if(cnt==1)
                        {
                            return true;
                        }
                      
                        conn.close();                       
                        prest.close();
                        
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
                       
                   return false;
        }

        public ArrayList getRegisteredCompanyInfoForUpdating(String loginid) 
        {
            ArrayList RegisteredCompanyInfoForUpdating = new ArrayList();

             String query = "select * FROM companies WHERE id=?;";
             
             try 
             {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                Statement stmt = null;
                ResultSet rs = null;

 
                PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);
                prest.setString(1, loginid);
                
                rs = prest.executeQuery();

                 if(rs.next()) 
                 {
                     
                     RegisteredCompanyInfoForUpdating.add(rs.getString("Name"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("type"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("sector"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("website"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("location"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("ctc"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("departments"));
                     RegisteredCompanyInfoForUpdating.add(rs.getFloat("cpi"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("contactname"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("designation"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("email"));
                     RegisteredCompanyInfoForUpdating.add(rs.getInt("mobile"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("id"));
                     RegisteredCompanyInfoForUpdating.add(rs.getString("password"));
                 }
                 conn.close();
                 stmt.close();
                 prest.close();

            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
             return RegisteredCompanyInfoForUpdating;
        }

        
        
        public boolean UpdateCompanyDetails(String id, ArrayList updating)
        {
            try
                     {
                         Class.forName(driver).newInstance();
                         Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
                         Connection conn1 = DriverManager.getConnection(url+dbName,userName,passwd);
                         
                        //String prequery="delete from companies where id=? ";
                        //PreparedStatement preprest = (PreparedStatement) conn.prepareStatement(prequery);
                        //preprest.setString(1, id);
                        //int precnt=preprest.executeUpdate();
                        
                        String query2="update companies set password=?,Name=?,type=?,sector=?,website=?,location=?,ctc=?,departments=?,cpi=?,contactname=?,designation=?,email=?,mobile=? where id=?";
                        //String query="INSERT INTO companies VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?,?,?);";                        
                        PreparedStatement prest = (PreparedStatement) conn1.prepareStatement(query2);
                         
                        
			prest.setString(1,(String)updating.get(1));
        		prest.setString(2,(String)updating.get(2));
			prest.setString(3,(String)updating.get(3));
                        prest.setString(4,(String)updating.get(4));
                        prest.setString(5,(String)updating.get(5));
			prest.setString(6,(String)updating.get(6));
                        prest.setString(7,(String)updating.get(7));
                        prest.setString(8,(String)updating.get(8));
                        prest.setFloat(9,Float.parseFloat((String)updating.get(9)));
        		prest.setString(10,(String)updating.get(10));
			prest.setString(11,(String)updating.get(11));
                        prest.setString(12,(String)updating.get(12));
                        prest.setInt(13,Integer.parseInt((String)updating.get(13)));
                        prest.setString(14,(String)updating.get(0));
                        
                        int cnt = prest.executeUpdate();
                        
                        if( cnt==1 )
                        {
                            return true;
                        }
                      
                        conn.close();  
                        conn1.close();
                        prest.close();
                        
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
                       
                   return false;
            }

            public boolean addCVInfoOfStudent(int rno, ArrayList storing)
            {
                try {
                    Class.forName(driver).newInstance();
                    Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                    Connection conn1 = DriverManager.getConnection(url + dbName, userName, passwd);

                   
                    
                    String query1 = "update students_info set cv1=? where roll=?;";
                    String query2 = "update students_info set cv2=? where roll=?;";
                                    
                   PreparedStatement prest1 = (PreparedStatement) conn.prepareStatement(query1);
                    PreparedStatement prest2 = (PreparedStatement) conn1.prepareStatement(query2);

                    if(!((String)storing.get(0)).equals("-"))
                    {
                        prest1.setString(1, (String) storing.get(0));
                        prest1.setInt(2, rno);
                        int cnt1 = prest1.executeUpdate();
                    }
                    
                    if(!((String)storing.get(1)).equals("-"))
                    {
                        prest2.setString(1, (String) storing.get(1));
                        prest2.setInt(2, rno);
                        int cnt2 = prest2.executeUpdate();
                    }
                    
                    conn.close();
                    conn1.close();
                    prest1.close();
                    prest2.close();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return true;
            }

            
            
            
            public boolean addDetailsOfCompany(String loginid, ArrayList storing) 
            {
                try 
                {   
                    Class.forName(driver).newInstance();
                    Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                    
                    String query1 = "update companies set details=? where id=?;";
                    
                                    
                   PreparedStatement prest1 = (PreparedStatement) conn.prepareStatement(query1);
                   

                    if(!((String)storing.get(0)).equals("-"))
                    {
                        prest1.setString(1, (String) storing.get(0));
                        prest1.setString(2, loginid);
                        int cnt1 = prest1.executeUpdate();
                    }
                   
                    conn.close();                    
                    prest1.close();                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return true;
            }

            
            
            public ArrayList getCVsofStudent(int rno) 
            {
                   ArrayList CVs= new ArrayList();
                   String query = "SELECT * FROM students_info WHERE roll=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setInt(1, rno);                      

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {                      
                               CVs.add(rs.getString("cv1"));
                               CVs.add(rs.getString("cv2"));
                       }
                       conn.close();
                       stmt.close();
                       prest.close();

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return CVs;
            }

            
            
            
              public boolean deleteFromApply(String rno, String Name, String Sector) 
              {
                  try {
                      Class.forName(driver).newInstance();
                      Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);

                      String query1 = "delete from apply where rno=? and company=? and sector=?;";


                      PreparedStatement prest1 = (PreparedStatement) conn.prepareStatement(query1);

                      prest1.setInt(1, Integer.parseInt(rno)); 
                      prest1.setString(2, Name);
                      prest1.setString(3, Sector);
                      
                      int updt = prest1.executeUpdate();
                      conn.close();
                      prest1.close();

                  } catch (Exception e) {
                      e.printStackTrace();
                  }

                  return true;
               }

              
              
              
                public boolean isAdminIdAlreadyExists(String loginid)
                {
                   String query = "SELECT * FROM privileges WHERE id=? and type=?;";
                   try 
                   {
                       Class.forName(driver).newInstance();
                       Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                       Statement stmt = null;
                       ResultSet rs = null;


                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                       prest.setString(1,loginid);
                       prest.setString(2,"admin");

                       rs = prest.executeQuery();

                       if (rs.next()) 
                       {
                           return true;
                       }
                       conn.close();
                       stmt.close();
                       prest.close();

                   } 
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                   return false;
                }

                
                
             public void insertIntoPriviles(String loginid, String password, String type) 
             {
                 String query = "INSERT INTO privileges values(?,?,?); ";

                 try {
                     Class.forName(driver).newInstance();
                     Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                     Statement stmt = null;



                     PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                     prest.setString(1, loginid);
                     prest.setString(2, password);
                     prest.setString(3, type);
                    

                     int rs = prest.executeUpdate();


                     conn.close();
                     stmt.close();
                     prest.close();

                 } catch (Exception e) {
                     e.printStackTrace();
                 }
            }

    
    
    
    
                    public String isThisStudentExists(String id)
                    {
                        String query = "SELECT * FROM current_students WHERE webmail=? ";
                        try {
                            Class.forName(driver).newInstance();
                            Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                            Statement stmt = null;
                            ResultSet rs = null;


                            PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                            
                            prest.setString(1, id);


                            rs = prest.executeQuery();

                            while(rs.next()) {
                                String pwd=rs.getString("password");
                                return pwd;
                            }
                            conn.close();
                            stmt.close();
                            prest.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return "";
                  }

                    
                    
            public void replacePR(String id, String pwd, String pr)        
            {
                    String query = "delete FROM privileges WHERE type=? ;";
                    
                        try {
                            Class.forName(driver).newInstance();
                            Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                            Statement stmt = null;
                            ResultSet rs = null;


                            PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                            
                            prest.setString(1, "PR");


                           int updt = prest.executeUpdate();

                            if (updt!=-1) {
                                insertIntoPriviles(id, pwd, pr);
                            }
                            conn.close();
                            stmt.close();
                            prest.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                      
            }

            
            
            
            public boolean deleteFromSchedule(String Company, String Sector) 
            {
                try {
                    Class.forName(driver).newInstance();
                    Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);

                    String query1 = "delete from schedule where company=? and sector=?;";


                    PreparedStatement prest1 = (PreparedStatement) conn.prepareStatement(query1);

                   
                    prest1.setString(1, Company);
                    prest1.setString(2, Sector);

                    int updt = prest1.executeUpdate();
                    conn.close();
                    prest1.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return true;
            }

            
            
            
            public boolean isDerAnyCompany(String Company, String Sector) 
            {
                    String query = "SELECT * FROM companies WHERE Name=? and sector=? ";
                try {
                    Class.forName(driver).newInstance();
                    Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                    Statement stmt = null;
                    ResultSet rs = null;


                    PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);


                    prest.setString(1, Company);
                    prest.setString(2, Sector);


                    rs = prest.executeQuery();

                    if (rs.next()) {
                        
                        return true;
                    }
                    conn.close();
                    stmt.close();
                    prest.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

            
            
            
            
                public void insertIntoSchedule(String Company, String Sector, String WrittenTest, String Timeslot, String Venue, int day) 
                {
                    String query = "INSERT INTO schedule values(?,?,?,?,?,?); ";

                    try {
                        Class.forName(driver).newInstance();
                        Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                        Statement stmt = null;



                        PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                        prest.setString(1, Company);
                        prest.setString(2, Sector);
                        prest.setString(3, WrittenTest);
                        prest.setString(4, Timeslot);
                        prest.setString(5, Venue);
                        prest.setInt(6, day);
                        


                        int updt = prest.executeUpdate();


                        conn.close();
                        stmt.close();
                        prest.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
                
                
                

                public boolean deleteUpdate(String Update) 
                {
                        try {
                        Class.forName(driver).newInstance();
                        Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);

                        String query1 = "delete from updates where Content=?;";


                        PreparedStatement prest1 = (PreparedStatement) conn.prepareStatement(query1);


                        prest1.setString(1, Update);
                        

                        int updt = prest1.executeUpdate();
                        conn.close();
                        prest1.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return true;
                }
                
                
                

                public boolean isDerAnyUpdate(String update)                
                {
                        String query = "SELECT * FROM updates WHERE Content=? ";
                    try {
                        Class.forName(driver).newInstance();
                        Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                        Statement stmt = null;
                        ResultSet rs = null;


                        PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);


                        prest.setString(1, update);
                        

                        rs = prest.executeQuery();

                        if (rs.next()) {

                            return true;
                        }
                        conn.close();
                        stmt.close();
                        prest.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                
                

                public boolean insertIntoUpdates(String update) 
                {
                        String query = "INSERT INTO updates (Content) values(?); ";

                        try {
                        Class.forName(driver).newInstance();
                        Connection conn = DriverManager.getConnection(url + dbName, userName, passwd);
                        Statement stmt = null;



                        PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query);

                        prest.setString(1, update);
                        
                        int updt = prest.executeUpdate();
                        
                        if(updt>0)
                        {
                            return true;
                        }

                        conn.close();
                        stmt.close();
                        prest.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                        
                        return false;
                                
                 }

    

        
    
}
