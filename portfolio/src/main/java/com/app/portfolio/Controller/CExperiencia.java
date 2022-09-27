
package com.app.portfolio.Controller;

import com.app.portfolio.service.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CExperiencia {
    
        @Autowired
    private IExperienciaService expServ;
}
