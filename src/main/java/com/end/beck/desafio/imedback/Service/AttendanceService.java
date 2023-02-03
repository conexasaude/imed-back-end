package com.end.beck.desafio.imedback.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Attendance;

@Service
public interface AttendanceService {
    
    public void existsAttendance(Attendance attendance);

    public List<Attendance> getAllAttendance();

    public Long getAttendanceById (Long id);

    public Attendance create(Attendance attendance);

    public Attendance update (Attendance attendance);
    
    public void delete(Long id);    
}
