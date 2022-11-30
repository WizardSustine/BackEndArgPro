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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sustine
 */
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 45, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 45, message = "no cumple con la longitud")
    private String apellido;
    
    @Size(min = 1, max = 250, message = "no cumple con la longitud")
    private String img;

    @Size(min = 1, max = 70, message = "no cumple con la longitud")
    private String position;
    
    @Size(min = 1, max = 70, message = "no cumple con la longitud")
    private String company;
    
    @Size(min = 1, max = 70, message = "no cumple con la longitud")
    private String ubicacion;
    
    @Size(min = 1, max = 255, message = "no cumple con la longitud")
    private String about;
}
