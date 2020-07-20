/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author POR
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
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
           // out.println("<h1>Servlet RegistrationController at " + request.getContextPath() + "</h1>");
            out.println("</html>");
           HttpSession session=request.getSession();
            Exists exists =  new Exists();
             String username=request.getParameter("uname");
            String password=request.getParameter("password");
            System.out.println(request.getParameter("button"));
             
        
                  if(  exists.isUser( username,password) == true ){
                      session.setAttribute("user",username);
                      DbConnection con=new DbConnection();
                       String id=con.getUserId(username);
                       session.setAttribute("userid",id);
                     
                      RequestDispatcher rd=request.getRequestDispatcher("indexv.jsp");
                       rd.forward(request, response);
                  }else{
                      out.print("Wrong username or password");
                  }
                  
                 }
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
          HttpSession session = request.getSession();
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
