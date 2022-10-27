
package com.app.portfolio.Controller;


import com.app.portfolio.model.Experiencia;
import com.app.portfolio.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/exp")
public class CExperiencia {
    
        @Autowired(required=false)
    private IExperienciaService expServ;
        
                 @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Experiencia exp) {
        expServ.crearExperiencia(exp);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia() {
        return expServ.verExperiencia();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }

    @PutMapping("/editar/{id}")
    public Experiencia editarExperiencia(@PathVariable Long id,
            @RequestParam("posicion") String nuevoposicion,
            @RequestParam("empresa") String nuevoempresa,
            @RequestParam("inicio") String nuevoinicio,
            @RequestParam("fin") String nuevofin,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("logo") String nuevologo) {
        Experiencia experiencia = expServ.buscarExperiencia(id);
        experiencia.setPosicion(nuevoposicion);
        experiencia.setEmpresa(nuevoempresa);
        experiencia.setInicio(nuevoinicio);
        experiencia.setFin(nuevofin);
        experiencia.setDescripcion(nuevoDescripcion); 
        experiencia.setLogo(nuevologo);
        expServ.crearExperiencia(experiencia);
        return experiencia;
    }
}

