
package com.app.portfolio.Controller;


import com.app.portfolio.model.Proyectos;
import com.app.portfolio.service.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CProyectos {
    
     @Autowired(required=false)
    private IProyectosService proServ;
    
         @PostMapping("/newproject")
    public void agregarProyecto(@RequestBody Proyectos pro) {
        proServ.crearProyecto(pro);
    }

    @GetMapping("/ver/proyectos")
    @ResponseBody
    public List<Proyectos> verProyecto() {
        return proServ.verProyectos();
    }

    @DeleteMapping("/deleteproject/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proServ.borrarProyecto(id);
    }

    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editarProyecto(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("linksitio") String nuevoLinkSitio,
            @RequestParam("linkcodigo") String nuevolinkCodigo,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("img") String nuevoImg) {
        Proyectos proyecto = proServ.buscarProyecto(id);
        proyecto.setNombre(nuevoNombre);
        proyecto.setLinkSitio(nuevoLinkSitio);
        proyecto.setLinkCodigo(nuevolinkCodigo);
        proyecto.setDescripcion(nuevoDescripcion); 
        proyecto.setImagen(nuevoImg);
        proServ.crearProyecto(proyecto);
        return proyecto;
    }
}

