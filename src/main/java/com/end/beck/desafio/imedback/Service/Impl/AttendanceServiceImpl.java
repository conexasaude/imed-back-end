package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Repository.AttendanceRepository;
import com.end.beck.desafio.imedback.Service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Page<Attendance> findAll(int page, int size) {
        
        Pageable pageResult =  PageRequest.of(page, size);

        return this.attendanceRepository.findAll(pageResult);
    }

    public Attendance findById(Long id, Attendance attendance) {
        
        this.attendanceRepository.findById(id);
        return attendance;
    }

    public Attendance create(Attendance attendance) {

        attendance.setStarDateTime(attendance.getStarDateTime());
        attendance.setEndDateTime(attendance.getEndDateTime());

        return this.attendanceRepository.save(attendance);

    }

    public Attendance update(Attendance attendance) {

        attendance.setPatient(attendance.getPatient());
        attendance.setHealthcareProfessional(attendance.getHealthcareProfessional());
        attendance.setStarDateTime(attendance.getStarDateTime());
        attendance.setEndDateTime(attendance.getEndDateTime());

        return this.attendanceRepository.save(attendance);
    }

    public String delete(Long id) {
      
        try {

            if(null != id) {
                this.attendanceRepository.deleteById(id);
            }                
                                
            return "deletado "+ id +" com sucesso";
        } catch (Exception e) {
           return e + "erro ao deletar atendimento";
        }
    }

    public void existsAttendance(Attendance attendance) {

        if (checkTime(attendance)) {
            throw new RuntimeException("Já possui um atendimento no hórario escolhido");
        }
    }

    private boolean checkTime(Attendance attendance) {
        return attendance.getStarDateTime() != null || attendance.getEndDateTime() != null;
    }
}
