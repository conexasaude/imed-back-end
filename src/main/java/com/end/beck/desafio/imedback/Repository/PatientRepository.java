 package com.end.beck.desafio.imedback.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    public Optional<Long> findByName(String name); 
       
}
