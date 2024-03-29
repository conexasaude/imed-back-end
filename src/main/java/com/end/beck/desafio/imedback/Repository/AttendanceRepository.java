package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.end.beck.desafio.imedback.Model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
    
    Page<Attendance> findAll(Pageable pageable);

}
