package com.app.portfolio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.portfolio.model.Persona;
import com.app.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController

public class Controller {
    
    @Autowired
    private IPersonaService personaServ;
 

    @PostMapping ("/new")
    public void agregarPersona (@RequestBody Persona pers) {
personaServ.crearPersona(pers);
}

    @GetMapping ("/ver/personas")
@ResponseBody
public List<Persona> verPersonas() {
return personaServ.verPersonas();
}

@DeleteMapping ("/delete/{id}")
public void borrarPersona (@PathVariable Long id){
    personaServ.borrarPersona(id);
}
}
