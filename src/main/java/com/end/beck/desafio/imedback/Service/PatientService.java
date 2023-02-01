package com.end.beck.desafio.imedback.Service;

import java.util.List;

import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;

public interface PatientService {

    public List<PatientAttendanceDTO> getHealthProfessionalByPatient(Long id , PatientAttendanceDTO patientAttendanceDTO);
    
}
