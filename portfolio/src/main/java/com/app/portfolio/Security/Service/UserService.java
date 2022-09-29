
package com.app.portfolio.Security.Service;

import com.app.portfolio.Security.Entity.User;
import com.app.portfolio.Security.Repository.IUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
    
    @Autowired
    IUserRepository iuserrepository;
    
    public Optional<User> getByUsername(String username){
        return iuserrepository.findByUsername(username);
    }
    
   public boolean existsByUsername(String username){
       return iuserrepository.existByUsername(username);
      
   } 
   
   public boolean existsByEmail(String email){
       return iuserrepository.existByEmail(email);
   }
   
   public void save(User user){
       iuserrepository.save(user);
   }
}
