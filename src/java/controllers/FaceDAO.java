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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author POR
 */
public class FaceDAO {
    private static FaceDAO instance;
public static FaceDAO getInstance() {
if (instance == null) {
instance = new FaceDAO();
}
return instance;
}
    
    public PersonalFeatures getPersonalFeatures(String user) {
    
    String sql="SELECT * FROM lab2.face WHERE userFace=? ";
    PersonalFeatures persFet=new PersonalFeatures();
    try (
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
     
    PreparedStatement prepStmt = conn.prepareStatement(sql);
    ){
    prepStmt.setString(1, user);
    ResultSet rs = prepStmt.executeQuery();
    while (rs.next()) {
        persFet.setFaceShape(rs.getString("shapeFace"));
        persFet.setFaceShape(rs.getString("colorFace"));
        persFet.setSkinType(rs.getString("skinType"));
                
    }
    } catch (SQLException ex) {
    ex.printStackTrace();
    }
    return persFet;
}
     public List<Products> getProducts(String user) {
    PersonalFeatures persFeat=new PersonalFeatures();
    persFeat=getPersonalFeatures(user);
    String sql="SELECT * FROM lab2.faceproducts WHERE shapeFace=? AND shapeColor= ? AND skinType= ?";
    List<Products> prods=new ArrayList<>();
    try (
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","miru");
     
    PreparedStatement prepStmt = conn.prepareStatement(sql);
    ){
    prepStmt.setString(1, persFeat.getFaceShape());
    prepStmt.setString(2, persFeat.getFaceColor());
    prepStmt.setString(3, persFeat.getSkinType());
    ResultSet rs = prepStmt.executeQuery();
    while (rs.next()) {
        prods.add(new Products(rs.getString("name"),rs.getString("description"),rs.getString("rating"),rs.getString("image"),rs.getString("ideyeproducts")) );
    }
    } catch (SQLException ex) {
    ex.printStackTrace();
    }
    return prods;
}
}

