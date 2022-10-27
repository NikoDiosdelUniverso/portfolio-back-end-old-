
package com.app.portfolio.Controller;


import com.app.portfolio.model.Skills;
import com.app.portfolio.service.ISkillsService;
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
@RequestMapping(path="/skill")
public class CSkills {
    
     @Autowired(required=false)
    private ISkillsService skillServ;
     
         @PostMapping("/new")
    public void agregarHabilidad(@RequestBody Skills skill) {
        skillServ.crearSkill(skill);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<Skills> verHabilidades() {
        return skillServ.verSkills();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarHabilidad(@PathVariable Long id) {
        skillServ.borrarSkill(id);
    }

    @PutMapping("editar/{id}")
    public Skills editarHabilidad(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("logo") String nuevoLogo) {
        Skills skill = skillServ.buscarSkill(id);
        skill.setNombre(nuevoNombre);

        skill.setLogo(nuevoLogo);
        skillServ.crearSkill(skill);
        return skill;
    }

    
}
