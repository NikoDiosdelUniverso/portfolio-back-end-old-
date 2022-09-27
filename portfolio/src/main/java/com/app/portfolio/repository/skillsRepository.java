
package com.app.portfolio.repository;

import com.app.portfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface skillsRepository extends JpaRepository <Skills, Long> {
    
}
