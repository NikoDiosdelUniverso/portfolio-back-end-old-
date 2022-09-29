
package com.app.portfolio.Security.Service;

import com.app.portfolio.Security.Entity.Role;
import com.app.portfolio.Security.Enums.RoleName;
import com.app.portfolio.Security.Repository.IRoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    
    @Autowired 
    IRoleRepository iRoleRepository;
    
    public Optional<Role> getByRoleName(RoleName rolName){
        return iRoleRepository.findByRoleName(rolName);
    }
    
    public void save(Role role) {
        iRoleRepository.save(role);
    }
}
