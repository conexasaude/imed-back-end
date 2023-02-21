package com.end.beck.desafio.imedback.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;

@Service
public interface PatientService {

    public List<Patient> findAll();

    public Patient findById (Long id, Patient patient);

    public Patient create(Patient patient);

    public Patient update (Patient patient);
    
    public String delete(Long id);  
    
    public PatientAttendanceDTO verificationAttendanceByConfirmation(PatientAttendanceDTO patientAttendanceDTO);
    
}
