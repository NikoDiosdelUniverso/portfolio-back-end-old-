package com.app.portfolio.Security.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
   
    @NotNull
    private String nombre;
    
    @NotNull
    @Column (unique = true)
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
    
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name= "user role", joinColumns= @JoinColumn(name = "user_id"), inverseJoinColumns= @JoinColumn(name= "role_id"))
    private Set<Rol> roles= new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String username, String email, String password) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    
}
