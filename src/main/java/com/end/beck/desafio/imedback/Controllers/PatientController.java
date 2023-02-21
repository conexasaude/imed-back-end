package com.end.beck.desafio.imedback.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;
import com.end.beck.desafio.imedback.Service.PatientService;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity <List<Patient>> findAll() {
        return ResponseEntity.ok(this.patientService.findAll());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Patient> getAttendancebyId(@PathVariable Long id, Patient patient) {
        return ResponseEntity.ok(this.patientService.findById(id, patient));
    }
   
    @PostMapping
    @ResponseBody
    public ResponseEntity<Patient> create(Patient patient) {                
        return ResponseEntity.ok(this.patientService.create(patient));
    }
  
    @PutMapping(path ="/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, Patient patient) {
        
        this.patientService.update(patient);
        
        return ResponseEntity.ok(patient);    
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.patientService.delete(id));                  
    }

    @PostMapping(path ="/{id}")
    public ResponseEntity<PatientAttendanceDTO> attendanceConfirmation(@PathVariable Long id, PatientAttendanceDTO patientAttendanceDTO){
       return ResponseEntity.ok(this.patientService.verificationAttendanceByConfirmation(patientAttendanceDTO));            
        
    }
    
}
