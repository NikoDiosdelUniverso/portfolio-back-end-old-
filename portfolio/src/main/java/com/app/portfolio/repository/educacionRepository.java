
package com.app.portfolio.repository;

import com.app.portfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface educacionRepository extends JpaRepository <Educacion, Long> {
    
}
