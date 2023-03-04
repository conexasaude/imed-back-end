 package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> { 
   
    Page<Patient> findAll(Pageable pageable);
    
}
