
package com.app.portfolio.Security.Entity;

import com.app.portfolio.Security.Enums.RoleName;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Enumerated
    private RoleName roleName;

    public Role() {
    }
    
    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
    
    
}
