
package com.app.portfolio.service;

import com.app.portfolio.model.Persona;
import com.app.portfolio.repository.personaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class PersonaService implements IPersonaService {

    @Autowired(required = false)
    public personaRepository personaRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return personaRepo.findAll();
}

    @Override
    public void crearPersona(Persona per) {
       personaRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }
    
}
