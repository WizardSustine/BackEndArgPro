/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Controller;

import com.backendportfolio.BackEnd.Entity.Habilidades;
import com.backendportfolio.BackEnd.Interface.HabilidadesInterf;
import com.backendportfolio.BackEnd.Security.Controller.Mensaje;
import com.backendportfolio.BackEnd.service.ImpHabilidadesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sustine
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadesController {
    @Autowired
    ImpHabilidadesService impHabilidadesService;
    
    @GetMapping("/habilidades/lista")
    public ResponseEntity<List<Habilidades>> list(){
        List<Habilidades> list = impHabilidadesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/habilidades/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!impHabilidadesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidades habilidades = impHabilidadesService.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    
    @DeleteMapping("/habilidades/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impHabilidadesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impHabilidadesService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/habilidades/create")
    public ResponseEntity<?> create(@RequestBody HabilidadesInterf habilidadesInterf){      
        if(StringUtils.isBlank(habilidadesInterf.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impHabilidadesService.existsByName(habilidadesInterf.getName()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades = new Habilidades(habilidadesInterf.getName(), habilidadesInterf.getImg(), habilidadesInterf.getPorcentaje());
        impHabilidadesService.save(habilidades);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/habilidades/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadesInterf habilidadesInterf){
        //Validamos si existe el ID
        if(!impHabilidadesService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de habilidades
        if(impHabilidadesService.existsByName(habilidadesInterf.getName()) && impHabilidadesService.getByName(habilidadesInterf.getName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(habilidadesInterf.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades = impHabilidadesService.getOne(id).get();
        habilidades.setName(habilidadesInterf.getName());
        habilidades.setImg(habilidadesInterf.getImg());
        habilidades.setPorcentaje(habilidadesInterf.getPorcentaje());
        
                
        impHabilidadesService.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }
}
