/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.logging.Logger;

/**
 *
 * @author POR
 */
public class Products {
    private String name;
    private String description;
    private String rating;
    private String image;
    private String id;

    public Products(String name, String description, String rating, String image, String id) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.image = image;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Products(String name, String description, String rating, String image) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
   
    
    
    
    
}
