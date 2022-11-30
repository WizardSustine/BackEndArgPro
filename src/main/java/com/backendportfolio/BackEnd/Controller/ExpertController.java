/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Controller;

import com.backendportfolio.BackEnd.Entity.Expert;
import com.backendportfolio.BackEnd.Interface.ExpertInterf;
import com.backendportfolio.BackEnd.Security.Controller.Mensaje;
import com.backendportfolio.BackEnd.service.ImpExpertService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
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
@RestController//@CrossOrigin(origins = "http://localhost:4200")
public class ExpertController {
    @Autowired
    ImpExpertService impExpertService;
    
    @GetMapping("/expert/lista")
    public ResponseEntity<List<Expert>> list(){
        List<Expert> list = impExpertService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/expert/detail/{id}")
    public ResponseEntity<Expert> getById(@PathVariable("id") int id){
        if(!impExpertService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Expert expert = impExpertService.getOne(id).get();
        return new ResponseEntity(expert, HttpStatus.OK);
    }
    
    @DeleteMapping("/expert/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impExpertService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impExpertService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/expert/create")
    public ResponseEntity<?> create(@RequestBody ExpertInterf expertInterf){      
        if(StringUtils.isBlank(expertInterf.getPosition()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impExpertService.existsByPosition(expertInterf.getPosition()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Expert expert = new Expert(expertInterf.getPosition(), expertInterf.getCompany(), expertInterf.getImg(), expertInterf.getDescription(), expertInterf.getMode(), expertInterf.getStartt(), expertInterf.getEndd(), expertInterf.getTimelapsed(), expertInterf.getCity());
        impExpertService.save(expert);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/expert/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExpertInterf expertInterf){
        //Validamos si existe el ID
        if(!impExpertService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impExpertService.existsByPosition(expertInterf.getPosition()) && impExpertService.getByPosition(expertInterf.getPosition()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(expertInterf.getPosition()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Expert expert = impExpertService.getOne(id).get();
        expert.setPosition(expertInterf.getPosition());
        expert.setCompany(expertInterf.getCompany());
        expert.setImg(expertInterf.getImg());
        expert.setDescription(expertInterf.getDescription());
        expert.setMode(expertInterf.getMode());
        expert.setStartt(expertInterf.getStartt());
        expert.setEndd(expertInterf.getEndd());
        expert.setTimelapsed(expertInterf.getTimelapsed());
        expert.setCity(expertInterf.getCity());
                
        impExpertService.save(expert);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}
