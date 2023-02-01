package com.end.beck.desafio.imedback.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;
import com.end.beck.desafio.imedback.Repository.PatientRepository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping(path="/list")
    public ResponseEntity <List<Patient>> getAllPatient() {
        return ResponseEntity.ok(this.patientRepository.findAll());
    }

    @GetMapping(path="/{id}")
    public Optional<Patient> getPatientbyId(@PathVariable Long id) {
        return this.patientRepository.findById(id);
    }
   
    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<Patient> addNewPatient(Patient patient) {
        
        patient.setDateCreated(ZonedDateTime.now());
        
        return ResponseEntity.ok(this.patientRepository.save(patient));
    }
    
    @PostMapping(path = "/list-attendance/{id}")
    public List<PatientAttendanceDTO> listAttendanceByHeathProfessional(
            @PathVariable Long id, 
            PatientAttendanceDTO patientAttendanceDTO
        ) {

           return new ArrayList<>();
            

    }
  
    @PutMapping(path ="/edit/{id}")
    public Patient updatePatientbyId(Patient patient) {
       
        this.patientRepository.save(patient);
        return patient;    
    }

    @DeleteMapping(path ="/delete/{id}")
    public String deletePatient(Patient patient) {
        this.patientRepository.deleteById(patient.getId());
        return "paciente " + patient.getId() + " deletado com sucesso";
    }
    
}
