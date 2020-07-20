/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author POR
 */
@WebServlet(name = "PersonalFeaturesController", urlPatterns = {"/PersonalFeaturesController"})
public class PersonalFeaturesController extends HttpServlet {

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
                Logger.getLogger(PersonalFeaturesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
                Logger.getLogger(PersonalFeaturesController.class.getName()).log(Level.SEVERE, null, ex);
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
                Connection conn=null;
                
               String eyeShape=request.getParameter("eyeShape");
                String eyeColor=request.getParameter("eyeColor");
                String user1=(String)request.getSession().getAttribute("user");
                DbConnection con=new DbConnection();
                
                String shapeLips=request.getParameter("lipShape");
                 String skinType=request.getParameter("skinType");
                String shapeFace=request.getParameter("shapeFace");
                String colorFace=request.getParameter("colorFace");
                con.setUserPersonalFeatures(eyeShape, eyeColor, shapeLips, shapeFace, colorFace, skinType,user1);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(PersonalFeaturesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
            Logger.getLogger(PersonalFeaturesController.class.getName()).log(Level.SEVERE, null, ex);
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
