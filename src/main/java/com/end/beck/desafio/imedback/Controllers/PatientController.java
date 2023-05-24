package com.end.beck.desafio.imedback.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.end.beck.desafio.imedback.Mapper.PatientMapper;
import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;
import com.end.beck.desafio.imedback.Model.DTO.PatientDTO;
import com.end.beck.desafio.imedback.Service.PatientService;

import java.util.List;

import org.springframework.data.domain.Page;
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
    public ResponseEntity <Page<Patient>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size

    ) {
        return ResponseEntity.ok(this.patientService.findAll(page, size));
    }

    @GetMapping(path="/{id}")
    public void getAttendancebyId(@PathVariable Long id, PatientDTO patientDTO) {
        Patient patient = PatientMapper.convertToEntity(patientDTO);
        this.patientService.findById(id, patient);
    }
   
    @PostMapping
    @ResponseBody
    public void create(PatientDTO patientDTO) {
        Patient patient = PatientMapper.convertToEntity(patientDTO);                
        this.patientService.create(patient);
    }
  
    @PutMapping(path ="/{id}")
    public void update(@PathVariable Long id, PatientDTO patientDTO) {
        Patient patient = PatientMapper.convertToEntity(patientDTO);
        this.patientService.update(patient);   
    }

    @DeleteMapping(path ="/{id}")
    public void delete(@PathVariable Long id) {
        this.patientService.delete(id);                  
    }

    @PostMapping(path ="/{id}")
    public void attendanceConfirmation(@PathVariable Long id, PatientAttendanceDTO patientAttendanceDTO){
       this.patientService.verificationAttendanceByConfirmation(patientAttendanceDTO);            
        
    }
    
}
