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
public class HabilidadesInterf {
    @NotBlank
    private String name;
    @NotBlank
    private String img;
    @NotBlank
    private int porcentaje;

    public HabilidadesInterf() {
    }

    public HabilidadesInterf(String name, String img, int porcentaje) {
        this.name = name;
        this.img = img;
        this.porcentaje = porcentaje;
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

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
