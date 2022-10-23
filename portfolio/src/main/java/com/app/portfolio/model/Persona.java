
package com.app.portfolio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String foto;
    @Column
    private String descripcion;
    @Column
    private String banner;
    
    public Persona() {
        
    }
    
    public Persona(Long id, String nombre, String apellido, String foto, String descripcion , String banner) {
        this.id = id;
        this.nombre= nombre;
        this.apellido=apellido;
        this.foto = foto;
        this.descripcion = descripcion;
        this.banner = banner;
    }
}
