/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.service;

import com.backendportfolio.BackEnd.Entity.Expert;
import com.backendportfolio.BackEnd.Repository.ExpertRepo;
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
public class ImpExpertService {
    @Autowired
     ExpertRepo expertRepo;
     
     public List<Expert> list(){
         return expertRepo.findAll();
     }
     
     public Optional<Expert> getOne(int id){
         return expertRepo.findById(id);
     }
     
     public Optional<Expert> getByPosition(String position){
         return expertRepo.findByPosition(position);
     }
     
     public void save(Expert expe){
         expertRepo.save(expe);
     }
     
     public void delete(int id){
         expertRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return expertRepo.existsById(id);
     }
     
     public boolean existsByPosition(String position){
         return expertRepo.existsByPosition(position);
     }
}
