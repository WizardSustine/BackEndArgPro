/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Controller;

import com.backendportfolio.BackEnd.Entity.Proyectos;
import com.backendportfolio.BackEnd.Interface.ProyectosInterf;
import com.backendportfolio.BackEnd.Security.Controller.Mensaje;
import com.backendportfolio.BackEnd.service.ImpProyectosService;
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
@CrossOrigin(origins = "https://portfolio-web-argentinap.web.app/")
public class ProyectosController {
    @Autowired
    ImpProyectosService impProyectosService;
    
    @GetMapping("/proyectos/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = impProyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/proyectos/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = impProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/proyectos/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impProyectosService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/proyectos/create")
    public ResponseEntity<?> create(@RequestBody ProyectosInterf proyectosInterf){      
        if(StringUtils.isBlank(proyectosInterf.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impProyectosService.existsByName(proyectosInterf.getName()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(proyectosInterf.getName(), proyectosInterf.getImg(), proyectosInterf.getLink(), proyectosInterf.getDescription());
        impProyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/proyectos/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectosInterf proyectosInterf){
        //Validamos si existe el ID
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de proyectos
        if(impProyectosService.existsByName(proyectosInterf.getName()) && impProyectosService.getByName(proyectosInterf.getName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(proyectosInterf.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = impProyectosService.getOne(id).get();
        proyectos.setName(proyectosInterf.getName());
        proyectos.setImg(proyectosInterf.getImg());
        proyectos.setLink(proyectosInterf.getLink());
        proyectos.setDescription(proyectosInterf.getDescription());
                
        impProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }
}
