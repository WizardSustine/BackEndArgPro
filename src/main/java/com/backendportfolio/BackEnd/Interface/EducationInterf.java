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
public class EducationInterf {
    @NotBlank
    private String career;
    @NotBlank
    private String school;
    @NotBlank
    private String degree;
    @NotBlank
    private String img;
    @NotBlank
    private String startt;
    @NotBlank
    private String endd;

    public EducationInterf() {
    }

    public EducationInterf(String career, String school, String degree, String img, String startt, String endd) {
        this.career = career;
        this.school = school;
        this.degree = degree;
        this.img = img;
        this.startt = startt;
        this.endd = endd;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
    
    
}
