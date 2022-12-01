
package com.backendportfolio.BackEnd.Controller;

import com.backendportfolio.BackEnd.Entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.backendportfolio.BackEnd.Interface.IPersonaService;
import org.springframework.web.bind.annotation.CrossOrigin;

/* 
 * @author Sustine
 */

@RestController
@CrossOrigin(origins = "https://portfolio-web-argentinap.web.app/")
public class PersonaController {

    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }
    
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre, @RequestParam("apellido") String nuevoApellido, @RequestParam("img") String nuevoImg, @RequestParam("position") String nuevoPosition, @RequestParam("company") String nuevoCompany, @RequestParam("ubicacion") String nuevoUbicacion, @RequestParam("about") String nuevoAbout){
        Persona persona = iPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setPosition(nuevoPosition);
        persona.setCompany(nuevoCompany);
        persona.setUbicacion(nuevoUbicacion);
        persona.setAbout(nuevoAbout);
        
        iPersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }
}
