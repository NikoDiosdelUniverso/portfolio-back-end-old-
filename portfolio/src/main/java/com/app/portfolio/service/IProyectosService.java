
package com.app.portfolio.service;

import com.app.portfolio.model.Proyectos;
import java.util.List;


public interface IProyectosService {
           public List<Proyectos> verProyectos ();
public void crearProyecto (Proyectos proyec);
public void borrarProyecto (Long id);
public Proyectos buscarProyecto (Long id);
 
    
}
