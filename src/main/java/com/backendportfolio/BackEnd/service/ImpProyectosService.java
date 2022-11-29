/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.service;

import com.backendportfolio.BackEnd.Entity.Proyectos;
import com.backendportfolio.BackEnd.Repository.ProyectosRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sustine
 */
@Service
@Transactional
public class ImpProyectosService {
    @Autowired
    ProyectosRepo proyectosRepo;
    
     public List<Proyectos> list(){
         return proyectosRepo.findAll();
     }
     
     public Optional<Proyectos> getOne(int id){
         return proyectosRepo.findById(id);
     }
     
     public Optional<Proyectos> getByName(String name){
         return proyectosRepo.findByName(name);
     }
     
     public void save(Proyectos proye){
         proyectosRepo.save(proye);
     }
     
     public void delete(int id){
         proyectosRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return proyectosRepo.existsById(id);
     }
     
     public boolean existsByName(String name){
         return proyectosRepo.existsByName(name);
     }
}
