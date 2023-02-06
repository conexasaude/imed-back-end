package com.end.beck.desafio.imedback.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Patient;

@Service
public interface PatientService {

    public List<Patient> getAllPatients();

    public Long getPatientById (Long id);

    public Patient create(Patient patient);

    public Patient update (Patient patient);
    
    public void delete(Long id);    
    
}
