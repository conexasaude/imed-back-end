package com.end.beck.desafio.imedback.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.end.beck.desafio.imedback.Model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

    Long findByAttendanceId (Long id);

    
    Optional<Attendance> findById(Long id);
}
