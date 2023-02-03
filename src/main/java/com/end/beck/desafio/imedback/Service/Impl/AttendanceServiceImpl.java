package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;
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

    public List<Attendance> getAllAttendance() {

        return this.attendanceRepository.findAll();
    }

    public Long getAttendanceById(Long id) {

        return this.attendanceRepository.findByAttendanceId(id);
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

    public void delete(Long id) {
        this.attendanceRepository.deleteById(id);
    }

    // public void verificationAttendanceByConfirmation(PatientAttendanceDTO
    // attendanceDTO) {

    // if(){
    // this.attendanceRepository.findByPatient();
    // }
    // }

    public void existsAttendance(Attendance attendance) {

        if (checkTime(attendance)) {
            throw new RuntimeException("Já possui um atendimento no hórario escolhido");
        }
    }

    private boolean checkTime(Attendance attendance) {
        return attendance.getStarDateTime() != null || attendance.getEndDateTime() != null;
    }
}
