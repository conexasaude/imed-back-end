package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;

public interface HealthcareProfessionalRepository extends JpaRepository<HealthcareProfessional,Long>{

    Page<HealthcareProfessional> findAll(Pageable pageable);
    
}
