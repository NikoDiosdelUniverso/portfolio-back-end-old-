
package com.app.portfolio.repository;

import com.app.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personaRepository extends JpaRepository <Persona, Long> {
    
}
