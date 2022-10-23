
package com.app.portfolio.service;

import com.app.portfolio.model.Proyectos;
import com.app.portfolio.repository.proyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService{

    @Autowired(required = false)
    public proyectosRepository proRepo;
    
    @Override
    public List<Proyectos> verProyectos() {
        return proRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyectos proyec) {
       proRepo.save(proyec);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyecto(Long id) {
       return proRepo.findById(id).orElse(null);
    }
    
}
