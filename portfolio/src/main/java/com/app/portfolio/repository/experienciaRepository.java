
package com.app.portfolio.repository;

import com.app.portfolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface experienciaRepository extends JpaRepository <Experiencia, Long> {
    
}
