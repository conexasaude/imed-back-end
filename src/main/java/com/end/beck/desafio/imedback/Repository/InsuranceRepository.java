package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.end.beck.desafio.imedback.Model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
    
}
