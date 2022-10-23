
package com.app.portfolio.Security.Service;

import com.app.portfolio.Security.Entity.Usuario;
import com.app.portfolio.Security.Repository.IUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
    
    @Autowired(required=false)
    IUserRepository iuserrepository;
    
    public Optional<Usuario> getByUsername(String username){
        return iuserrepository.findByUsername(username);
    }
    
   public boolean existsByUsername(String username){
       return iuserrepository.existByUsername(username);
      
   } 
   
   public boolean existsByEmail(String email){
       return iuserrepository.existByEmail(email);
   }
   
   public void save(Usuario user){
       iuserrepository.save(user);
   }
}
