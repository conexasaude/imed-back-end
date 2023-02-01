package com.end.beck.desafio.imedback.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Attendance;

@Service
public interface AttendanceService {
    
    public void existsAttendance(Attendance attendance);

    public List<Attendance> getAllAttendance();

    public Optional<Attendance> getAttendanceById (Long id);

    public Attendance createAttendance(Attendance attendance);

    public Attendance updateAttendance (Attendance attendance);
    
    public void deleteAttendance(Long id);    
}
