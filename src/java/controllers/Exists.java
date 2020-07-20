/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.*;
import java.text.ParseException;
public class Exists {
   
  
            
    public boolean userExists(String username) throws SQLException{
          
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
            System.out.println("Connected");
            //Statement stmt=(Statement)conn.createStatement();
             java.sql.Statement stmt=(java.sql.Statement)conn.createStatement();
    
        ResultSet rs=stmt.executeQuery("SELECT username FROM lab2.users;  ");
 
        while(rs.next()){
            String user=rs.getString("username");
            if(user.equals(username)){
                
                return true;
            }
        }
        return false;
    }
    public boolean isUser(String username,String password) throws SQLException{
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
            System.out.println("Connected");
            //Statement stmt=(Statement)conn.createStatement();
             java.sql.Statement stmt=(java.sql.Statement)conn.createStatement();
      String pass1=stmt.executeQuery("SELECT SHA1(\'"+password+"\')").toString();
      java.sql.Statement stmt1=(java.sql.Statement)conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT username,password FROM lab2.users;  ");
 
        while(rs.next()){
            String user=rs.getString("username");
            String pass=rs.getString("password");
            if(user.equals(username)&&pass.equals(pass)){
                
                return true;
            }
        }
        return false;
    }
    }
    

