package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.end.beck.desafio.imedback.Model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

    @Query(value = "select * from attendance where id = :id", nativeQuery = true )
    Long findByAttendanceId (Long id);
    
}
