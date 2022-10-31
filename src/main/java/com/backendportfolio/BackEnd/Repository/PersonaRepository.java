
package com.backendportfolio.BackEnd.Repository;

import com.backendportfolio.BackEnd.Persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sustine
 */

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
