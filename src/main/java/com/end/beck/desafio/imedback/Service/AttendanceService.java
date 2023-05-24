package com.end.beck.desafio.imedback.Service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Attendance;

@Service
public interface AttendanceService {
    
    void existsAttendance(Attendance attendance);

    Page<Attendance> findAll(int page, int size);

    Attendance findById(Long id, Attendance attendance);

    Attendance create(Attendance attendance);

    Attendance update (Attendance attendance);

    String delete(Long id);    

}
