
package com.app.portfolio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
    @Column
    private String titulo;
    @Column
    private String establecimiento;
    @Column
    private String logo;
    @Column
    private String inicio;
    @Column
    private String fin;
    @Column
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
