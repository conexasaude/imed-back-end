package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
    
}
