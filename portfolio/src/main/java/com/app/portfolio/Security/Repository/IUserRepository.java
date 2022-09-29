
package com.app.portfolio.Security.Repository;

import com.app.portfolio.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    
    boolean existByUsername(String username);
    boolean existByEmail(String email);
}
