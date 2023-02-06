package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;

@Repository
public interface HealthcareProfessionalRepository extends JpaRepository<HealthcareProfessional,Long>{

    @Query(value = "Select * health_care_professional where id = :id", nativeQuery = true)
    public Long findByHeathcareProfessionalId (Long id);
    
}
