
package com.app.portfolio.Controller;

import com.app.portfolio.service.IEducacionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CEducacion {
    
        @Autowired
    private IEducacionservice eduServ;
    
}
