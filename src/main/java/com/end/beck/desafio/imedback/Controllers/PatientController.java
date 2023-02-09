package com.end.beck.desafio.imedback.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.end.beck.desafio.imedback.Model.Patient;
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

    @GetMapping(path="/patients")
    public ResponseEntity <List<Patient>> getAllAttendance() {
        return ResponseEntity.ok(this.patientService.getAllPatients());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Long> getAttendancebyId(@PathVariable Long id) {
        return ResponseEntity.ok(this.patientService.getPatientById(id));
    }
   
    @PostMapping(path="/patient")
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
    
}
