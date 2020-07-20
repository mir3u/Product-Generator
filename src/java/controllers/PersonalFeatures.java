/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author POR
 */
public class PersonalFeatures {
    private String eyeShape;
    private String eyeColor;
    private String faceShape;
    private String faceColor;
    private String lipsShape;
    private String skinType;

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
    

    public PersonalFeatures(String eyeShape, String eyeColor) {
        this.eyeShape = eyeShape;
        this.eyeColor = eyeColor;
    }

    public PersonalFeatures(String lipsShape) {
        this.lipsShape = lipsShape;
    }

    public PersonalFeatures() {
    }

    public String getEyeShape() {
        return eyeShape;
    }

    public void setEyeShape(String eyeShape) {
        this.eyeShape = eyeShape;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getFaceShape() {
        return faceShape;
    }

    public void setFaceShape(String faceShape) {
        this.faceShape = faceShape;
    }

    public String getFaceColor() {
        return faceColor;
    }

    public void setFaceColor(String faceColor) {
        this.faceColor = faceColor;
    }

    public String getLipsShape() {
        return lipsShape;
    }

    public void setLipsShape(String lipsShape) {
        this.lipsShape = lipsShape;
    }
    
    
    
    
}
