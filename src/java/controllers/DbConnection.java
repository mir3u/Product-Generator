/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;


/**
 *
 * @author POR
 */
public class DbConnection {
   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public String getUserId(String user)throws SQLException, NamingException{
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
    System.out.println("Connected");
    String a="SELECT idusers FROM users WHERE username ='"+user+"'";
    String id=null;
    Statement instr = conn.createStatement();
    ResultSet rs = instr.executeQuery(a);
    while(rs.next()){
        id=rs.getString("idusers");}
    return id;
}
public void setUserPersonalFeatures(String eyeShape,String eyeColor,String shapeLips,String shapeFace,String colorFace,String skinType,String user) throws SQLException, NamingException{
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
     System.out.println("Connected");
       String id=getUserId(user);         
     String insert="INSERT INTO lab2.eyes(eyeShape,eyeColor,userEye) VALUES (\'"+eyeShape+"\',\'"+eyeColor+"\',\'"+id+"\')";
                //stmt.executeUpdate(insert);
    PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
      ps.execute();
                
    insert="INSERT INTO lab2.lips(shapeLips,userLips) VALUES (\'"+shapeLips+"\',\'"+id+"\')";
    ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
     ps.execute();
                
               
    insert="INSERT INTO lab2.face(shapeFace,colorFace,skinType,userFace) VALUES (\'"+shapeFace+"\',\'"+colorFace+"\',\'"+skinType+"\',\'"+id+"\')";
   ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
      ps.execute();
}

//    public ArrayList<Products> prodList() throws SQLException, NamingException{
//            ArrayList<Products> prod=new ArrayList<Products>();
//             Connection conn=null;
//      
//      try{
//
//           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
//            System.out.println("Connected");
//            Statement stmt=(Statement)conn.createStatement();
//            
//      
//            ResultSet rs=stmt.executeQuery("SELECT * FROM lab2.products;");
// 
//        while(rs.next()){
//            String name=rs.getString("name");
//            String type=rs.getString("type");
//            String description=rs.getString("description");
//            String price=rs.getString("price");
//        //Products newProd=new Products(name,Integer.parseInt(price),description,type);
//        Products newProd=new Products(name,Integer.parseInt(price));
//            prod.add(newProd);  
//           
//        }
//         }catch (SQLException e){
//            e.printStackTrace();
//        }
//    
//    return prod;
//    }
//}
 
}

