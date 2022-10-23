
package com.app.portfolio.service;

import com.app.portfolio.model.Experiencia;
import com.app.portfolio.repository.experienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired(required=false)
    public experienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
       expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
       expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
}
