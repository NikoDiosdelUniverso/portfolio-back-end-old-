
package com.app.portfolio.service;

import com.app.portfolio.model.Educacion;
import com.app.portfolio.repository.educacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class EducacionService implements IEducacionservice{

    @Autowired(required = false)
    public educacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
       eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
}
