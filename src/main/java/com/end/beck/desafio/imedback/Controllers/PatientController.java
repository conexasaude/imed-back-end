package com.end.beck.desafio.imedback.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;
import com.end.beck.desafio.imedback.Repository.PatientRepository;
import com.end.beck.desafio.imedback.Service.PatientService;

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
    public ResponseEntity<Patient> update(Patient patient) {
        
        this.patientService.update(patient);
        
        return ResponseEntity.ok(patient);    
    }

    @DeleteMapping(path ="/{id}")
    public String delete(@PathVariable Long id) throws Exception{
        
        try {
            this.patientService.delete(id);            
            return "deletado com"+ id +" sucesso";
        } catch (Exception e) {
            throw new Exception("paciente não econtrodado", e);
        }
        
    }
    
}
