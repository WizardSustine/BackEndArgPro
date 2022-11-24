/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Interface;

import com.backendportfolio.BackEnd.Entity.Persona;
import java.util.List;

/**
 *
 * @author Sustine
 */
public interface IPersonaService {
    //Traer lista de personas
     public List<Persona> getPersona ();
     
     //Guardar objeto
     public void savePersona(Persona persona);
         
     //Eliminar usuario
     public void deletePersona(Long id);
     
     //Buscar Persona
     public Persona findPersona(Long id);
}
