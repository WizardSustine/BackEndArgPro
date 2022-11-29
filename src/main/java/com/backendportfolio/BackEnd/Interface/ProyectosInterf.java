/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Interface;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Sustine
 */
public class ProyectosInterf {
    @NotBlank
    private String name;
    @NotBlank
    private String img;
    @NotBlank
    private String link;
    @NotBlank
    private String description;

    public ProyectosInterf() {
    }

    public ProyectosInterf(String name, String img, String link, String description) {
        this.name = name;
        this.img = img;
        this.link = link;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
