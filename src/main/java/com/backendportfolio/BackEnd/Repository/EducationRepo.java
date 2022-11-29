/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backendportfolio.BackEnd.Repository;

import com.backendportfolio.BackEnd.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sustine
 */
@Repository
public interface EducationRepo extends JpaRepository<Education, Integer>{
    public Optional<Education> findByCareer(String career);
    public boolean existsByCareer(String career);
}
