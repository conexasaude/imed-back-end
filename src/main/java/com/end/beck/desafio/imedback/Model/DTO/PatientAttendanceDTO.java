package com.end.beck.desafio.imedback.Model.DTO;

import java.io.Serializable;

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Model.HealthcareProfessional;

import lombok.Data;

@Data
public class PatientAttendanceDTO implements Serializable {

    private Long id;
    private HealthcareProfessional healthcareProfessional;
    private Attendance attendance;
    private boolean confirmationAttendance;    
}