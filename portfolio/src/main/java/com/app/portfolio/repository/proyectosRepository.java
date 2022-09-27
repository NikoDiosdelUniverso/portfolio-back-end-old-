
package com.app.portfolio.repository;

import com.app.portfolio.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface proyectosRepository extends JpaRepository <Proyectos, Long> {
    
}
