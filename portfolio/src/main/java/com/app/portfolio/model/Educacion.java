
package com.app.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
    
    private String titulo;
    private String establecimiento;
    private String logo;
    private String inicio;
    private String fin;
    private String descripcion;
    
    public Educacion() {
        
    }
    
    public Educacion(Long id,String titulo,String establecimiento, String logo,String inicio,String fin,String descripcion) {
           this.id = id;
           this.titulo = titulo;
           this.establecimiento = establecimiento;
           this.inicio = inicio;
           this.fin = fin;
           this.descripcion = descripcion ;
           this.logo= logo;
    }
}
