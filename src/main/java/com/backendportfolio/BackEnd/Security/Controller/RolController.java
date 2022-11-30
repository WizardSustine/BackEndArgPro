/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Security.Controller;

import com.backendportfolio.BackEnd.Security.Entity.Rol;
import com.backendportfolio.BackEnd.Security.Enums.RolNombre;
import com.backendportfolio.BackEnd.Security.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sustine
 */
@RestController
public class RolController {
    @Autowired
    RolService rolService;
    
    @PutMapping("/rol/create")
    public ResponseEntity<?> create(@RequestParam("nombre") RolNombre nuevoNombre){              
        Rol rol = new Rol();
        rol.setRolNombre(nuevoNombre);
        
        rolService.save(rol);
        return new ResponseEntity(new Mensaje("Rol agregado" + rol.getRolNombre() + rol.getId()), HttpStatus.OK);
    }
}
