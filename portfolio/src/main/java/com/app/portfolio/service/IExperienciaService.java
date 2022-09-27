
package com.app.portfolio.service;

import com.app.portfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
       public List<Experiencia> verExperiencia ();
public void crearExperiencia (Experiencia exp);
public void borrarExperiencia (Long id);
public Experiencia buscarExperiencia (Long id);
 
}
