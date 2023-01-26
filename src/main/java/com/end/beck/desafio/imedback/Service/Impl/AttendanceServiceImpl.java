package com.end.beck.desafio.imedback.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Repository.AttendanceRepository;
import com.end.beck.desafio.imedback.Service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private final AttendanceRepository attendanceRepository;

    
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendance() {
        
        return this.attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById (Long id) {

        return this.attendanceRepository.findById(id);
    }

    public Attendance createAttendance(Attendance attendance) {
       
        attendance.setStarDateTime(attendance.getStarDateTime());
        attendance.setEndDateTime(attendance.getEndDateTime());
        
        return this.attendanceRepository.save(attendance);

    }

    public Attendance updateAttendance(Attendance attendance) {

        attendance.setPatient(attendance.getPatient());
        attendance.setHealthcareProfessional(attendance.getHealthcareProfessional());
        attendance.setStarDateTime(attendance.getStarDateTime());
        attendance.setEndDateTime(attendance.getEndDateTime());        

        return this.attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id){
        this.attendanceRepository.deleteById(id);
    }
    
    
    public void existsAttendance(Attendance attendance) {
        if(checkTime(attendance)){
            throw new RuntimeException("Já possui um atendimento no hórario escolhido");
        }
    }

    private boolean checkTime(Attendance attendance) {
        return attendance.getStarDateTime() != null || attendance.getEndDateTime() != null;
    }
}
