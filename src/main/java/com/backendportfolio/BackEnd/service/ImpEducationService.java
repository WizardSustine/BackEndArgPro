/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.service;

import com.backendportfolio.BackEnd.Entity.Education;
import com.backendportfolio.BackEnd.Repository.EducationRepo;
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
public class ImpEducationService {
    @Autowired
    EducationRepo educationRepo;
    
    public List<Education> list(){
         return educationRepo.findAll();
     }
     
     public Optional<Education> getOne(int id){
         return educationRepo.findById(id);
     }
     
     public Optional<Education> getByCareer(String career){
         return educationRepo.findByCareer(career);
     }
     
     public void save(Education edu){
         educationRepo.save(edu);
     }
     
     public void delete(int id){
         educationRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return educationRepo.existsById(id);
     }
     
     public boolean existsByCareer(String career){
         return educationRepo.existsByCareer(career);
     }
}
