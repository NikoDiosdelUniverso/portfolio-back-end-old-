
package com.app.portfolio.Controller;

import com.app.portfolio.service.ISkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CSkills {
    
     @Autowired
    private ISkillsService skillServ;
    
}
