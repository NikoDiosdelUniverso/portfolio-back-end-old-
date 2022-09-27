
package com.app.portfolio.service;

import com.app.portfolio.model.Educacion;
import java.util.List;


public interface IEducacionservice {
    
    public List<Educacion> verEducacion ();
public void crearEducacion (Educacion edu);
public void borrarEducacion (Long id);
public Educacion buscarEducacion (Long id);

}
