/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.service;

import com.backendportfolio.BackEnd.Entity.Habilidades;
import com.backendportfolio.BackEnd.Repository.HabilidadesRepo;
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
public class ImpHabilidadesService {
    @Autowired
    HabilidadesRepo habilidadesRepo;
    
    public List<Habilidades> list(){
         return habilidadesRepo.findAll();
     }
     
     public Optional<Habilidades> getOne(int id){
         return habilidadesRepo.findById(id);
     }
     
     public Optional<Habilidades> getByName(String name){
         return habilidadesRepo.findByName(name);
     }
     
     public void save(Habilidades habi){
         habilidadesRepo.save(habi);
     }
     
     public void delete(int id){
         habilidadesRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return habilidadesRepo.existsById(id);
     }
     
     public boolean existsByName(String name){
         return habilidadesRepo.existsByName(name);
     }
}
