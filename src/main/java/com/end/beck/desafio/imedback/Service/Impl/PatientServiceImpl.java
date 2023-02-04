package com.end.beck.desafio.imedback.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;
import com.end.beck.desafio.imedback.Repository.PatientRepository;
import com.end.beck.desafio.imedback.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

   
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {

        return this.patientRepository.findAll();
    }

    public Long getPatientById(Long id) {

        return this.patientRepository.findByPatientId(id);
    }

    public Patient create(Patient patient) {

        return this.patientRepository.save(patient);

    }

    public Patient update(Patient patient) {

        

        return this.patientRepository.save(patient);
    }

    public void delete(Long id) {
        this.patientRepository.deleteById(id);
    }
  
}
