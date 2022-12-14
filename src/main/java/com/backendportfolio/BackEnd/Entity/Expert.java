/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sustine
 */
@Entity
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String position;
    private String company;
    private String img;
    private String description;
    private String mode;
    private String startt;
    private String endd;
    private String timelapsed;
    private String city;

    public Expert() {
    }

    public Expert(String position, String company, String img, String description, String mode, String startt, String endd, String timelapsed, String city) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
