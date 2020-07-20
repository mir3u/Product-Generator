/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


public class RegistrationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   // private static final String USERNAME="root";
    //private static final String PASSWORD="cristina";
   //private static final String CONN_STRING="jdbc:mysql://localhost:3306/lab2";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>");  
            out.println("<title>Servlet RegistrationController</title>");  
            out.println("<meta charset=\"UTF-8\">");  
            out.println("<meta name=\"viewport\" content=\"width=device-width\">");  
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"content\">");
            out.println("<div class=\"header\">");
            out.println("<img src=\"./img/companyLogo.jpg\" width=\"100px\"  />");
            out.println("<span class=\"header-text\">COMPANY NAME</span>");  
            out.println("</div>");  
            out.println("<nav>");  
            out.println("<ul>");  
            out.println("<li><a href=\"#\">Home</a></li>");
            out.println("<li><a href=\"#\">Register</a></li>");
            out.println("<li><a href=\"#\">Contact</a></li>");  
            out.println("</ul>");
            out.println("</nav>");
            out.println("<h1>Servlet RegistrationController at " + request.getContextPath() + "</h1>");
            Map m=request.getParameterMap();
            Set s = m.entrySet();
            Iterator it = s.iterator();
            Exists exists =  new Exists();
            while(it.hasNext()){
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

                String key = entry.getKey();
                String[] value = entry.getValue();

                for (int i = 0; i < value.length; i++) {
                  
                  if(  exists.userExists( value[i] ) == true ){
                        out.print("User already exists");
                  }else{
                      out.print("Parameter " + key + " has value " + value[i] + "</br>");
                  }
                 }
            }
            out.println("</body>");
           
            //?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT",
           Connection conn=null;
           HttpSession session=request.getSession();
      
      try{
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
            System.out.println("Connected");
            //Statement stmt=(Statement)conn.createStatement();
             String name=request.getParameter("name");
            String username=request.getParameter("uname");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            String gender=request.getParameter("gender");
            String country=request.getParameter("country");
            String tel=request.getParameter("tel");
             java.sql.Statement stmt=(java.sql.Statement)conn.createStatement();
            
            String insert="INSERT INTO lab2.users(name,username,password,email,gender,country,tel) VALUES (\'"+name+"\',\'"+username+"\',SHA1(\'"+password+"\'),\'"+email+"\',\'"+gender+"\',\'"+country+"\',\'"+tel+"\')";
             //stmt.executeUpdate(insert);
              PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
              ps.execute();
            session.setAttribute("user",username);
              
              RequestDispatcher rd=request.getRequestDispatcher("personalFeatures.jsp");
                       rd.forward(request, response);
        }catch (SQLException e){
            e.printStackTrace();
        }
      
        } out.println("</html>");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
