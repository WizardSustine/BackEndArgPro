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
public class ExpertInterf {
    @NotBlank
    private String position;
    @NotBlank
    private String company;
    @NotBlank
    private String img;
    @NotBlank
    private String description;
    @NotBlank
    private String mode;
    @NotBlank
    private String startt;
    @NotBlank
    private String endd;
    @NotBlank
    private String timelapsed;
    @NotBlank
    private String city;

    public ExpertInterf() {
    }

    public ExpertInterf(String position, String company, String img, String description, String mode, String startt, String endd, String timelapsed, String city) {
        this.position = position;
        this.company = company;
        this.img = img;
        this.description = description;
        this.mode = mode;
        this.startt = startt;
        this.endd = endd;
        this.timelapsed = timelapsed;
        this.city = city;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStartt() {
        return startt;
    }

    public void setStartt(String startt) {
        this.startt = startt;
    }

    public String getEndd() {
        return endd;
    }

    public void setEndd(String endd) {
        this.endd = endd;
    }

    public String getTimelapsed() {
        return timelapsed;
    }

    public void setTimelapsed(String timelapsed) {
        this.timelapsed = timelapsed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
