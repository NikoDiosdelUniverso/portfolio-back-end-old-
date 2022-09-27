
package com.app.portfolio.Controller;

import com.app.portfolio.service.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CProyectos {
    
     @Autowired
    private IProyectosService proServ;
    
}
