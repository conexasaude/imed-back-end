package com.end.beck.desafio.imedback.Controllers;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;
import com.end.beck.desafio.imedback.Repository.HealthcareProfessionalRepository;

@RestController
@RequestMapping(path = "/healthcareProfessional")
public class HealthcareProfessionalController {
    @Autowired
    private final HealthcareProfessionalRepository healthcareProfessionalRepository;


    public HealthcareProfessionalController(HealthcareProfessionalRepository healthcareProfessionalRepository) {
        this.healthcareProfessionalRepository = healthcareProfessionalRepository;
    }

    @GetMapping(path="/list")
    public ResponseEntity <List<HealthcareProfessional>> getAllPatient() {
        return ResponseEntity.ok(this.healthcareProfessionalRepository.findAll());
    }

    @GetMapping(path="/{id}")
    public Optional<HealthcareProfessional> getPatientbyId(@PathVariable Long id) {
        return this.healthcareProfessionalRepository.findById(id);
    }
   
    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<HealthcareProfessional> addNewPatient(HealthcareProfessional healthcareProfessional) {
        
        healthcareProfessional.setCreatedDate(ZonedDateTime.now());
        
        return ResponseEntity.ok(this.healthcareProfessionalRepository.save(healthcareProfessional));
    }

  
    @PutMapping(path ="/edit/{id}")
    public HealthcareProfessional updatePatientbyId(HealthcareProfessional healthcareProfessional) {
       
        this.healthcareProfessionalRepository.save(healthcareProfessional);
        return healthcareProfessional;    
    }

    @DeleteMapping(path ="/delete/{id}")
    public String deletePatient(HealthcareProfessional healthcareProfessional) {
        this.healthcareProfessionalRepository.deleteById(healthcareProfessional.getId());
        return "paciente " + healthcareProfessional.getId() + " deletado com sucesso";
    }

    
}