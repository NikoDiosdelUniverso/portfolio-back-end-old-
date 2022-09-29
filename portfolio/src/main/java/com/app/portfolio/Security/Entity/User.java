package com.app.portfolio.Security.Entity;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
   
    private String nombre;
    
    @Column (unique = true)
    private String username;
    private String email;
    private String password;
    
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name= "user role", joinColumns= @JoinColumn(name = "user_id"), inverseJoinColumns= @JoinColumn(name= "role_id"))
    private Set<Role> roles= new HashSet<>();

    public User() {
    }

    public User(String nombre, String username, String email, String password) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    
}
