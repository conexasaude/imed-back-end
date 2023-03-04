package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
    
    Page<Insurance> findAll(Pageable pageable);

}
