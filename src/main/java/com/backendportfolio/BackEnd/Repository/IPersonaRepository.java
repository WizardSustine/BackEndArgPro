
package com.backendportfolio.BackEnd.Repository;

import com.backendportfolio.BackEnd.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sustine
 */

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
