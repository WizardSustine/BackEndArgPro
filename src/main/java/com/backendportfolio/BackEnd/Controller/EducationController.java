/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Controller;

import com.backendportfolio.BackEnd.Entity.Education;
import com.backendportfolio.BackEnd.Interface.EducationInterf;
import com.backendportfolio.BackEnd.Security.Controller.Mensaje;
import com.backendportfolio.BackEnd.service.ImpEducationService;
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
public class EducationController {
    @Autowired
    ImpEducationService impEducationService;
    
    @GetMapping("/education/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = impEducationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/education/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!impEducationService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Education education = impEducationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/education/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impEducationService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/education/create")
    public ResponseEntity<?> create(@RequestBody EducationInterf educationInterf){      
        if(StringUtils.isBlank(educationInterf.getCareer()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impEducationService.existsByCareer(educationInterf.getCareer()))
            return new ResponseEntity(new Mensaje("Esa educación existe"), HttpStatus.BAD_REQUEST);
        
        Education education = new Education(educationInterf.getCareer(), educationInterf.getSchool(), educationInterf.getDegree(), educationInterf.getImg(), educationInterf.getStartt(), educationInterf.getEndd());
        impEducationService.save(education);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/education/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationInterf educationInterf){
        //Validamos si existe el ID
        if(!impEducationService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de educación
        if(impEducationService.existsByCareer(educationInterf.getCareer()) && impEducationService.getByCareer(educationInterf.getCareer()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(educationInterf.getCareer()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Education education = impEducationService.getOne(id).get();
        education.setCareer(educationInterf.getCareer());
        education.setSchool(educationInterf.getSchool());
        education.setDegree(educationInterf.getDegree());
        education.setImg(educationInterf.getImg());
        education.setStartt(educationInterf.getStartt());
        education.setEndd(educationInterf.getEndd());
                
        impEducationService.save(education);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
             
    }
}
