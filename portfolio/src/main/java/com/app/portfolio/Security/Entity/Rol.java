
package com.app.portfolio.Security.Entity;

import com.app.portfolio.Security.Enums.RoleName;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated
    private RoleName roleName;

    public Rol() {
    }
    
    public Rol(RoleName roleName) {
        this.roleName = roleName;
    }
    
    
}
