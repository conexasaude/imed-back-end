package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Patient;
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
        
        patient.setName(patient.getName());
        patient.setOnlineStatus(patient.getOnlineStatus());
        patient.setTotalAppointment(patient.getTotalAppointment());        

        return this.patientRepository.save(patient);
    }

    public String delete(Long id) {
        try {
            this.patientRepository.deleteById(id);
                                    
            return "deletado "+ id +" com sucesso";
        } catch (Exception e) {
           return e + "erro ao deletar paciente";
        }
    }
  
}
