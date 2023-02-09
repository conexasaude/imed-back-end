package com.end.beck.desafio.imedback.Controllers;

import java.time.ZonedDateTime;
import java.util.List;

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
import com.end.beck.desafio.imedback.Service.HealthcareProfessionalService;

@RestController
@RequestMapping(path = "/healthcare-professional")
public class HealthcareProfessionalController {    
    
    
    private final HealthcareProfessionalService healthcareProfessionalService;
    
    public HealthcareProfessionalController(HealthcareProfessionalService healthcareProfessionalService) {
        this.healthcareProfessionalService = healthcareProfessionalService;
    }
   
    @GetMapping(path="/healthcare-professionals")
    public ResponseEntity <List<HealthcareProfessional>> healthcareProfessionals() {
        return ResponseEntity.ok(this.healthcareProfessionalService.getAllHealthcareProfessional());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Long> findOneHealtchcareProfessional(@PathVariable Long id) {
        return ResponseEntity.ok(this.healthcareProfessionalService.findByHeathcareProfessionalId(id));
    }
   
    @PostMapping(path="/healthcare-professional")
    @ResponseBody
    public ResponseEntity<HealthcareProfessional> create(HealthcareProfessional healthcareProfessional) {
        
        healthcareProfessional.setCreatedDate(ZonedDateTime.now());
        
        return ResponseEntity.ok(this.healthcareProfessionalService.createHealthcareProfessional(healthcareProfessional));
    }
  
    @PutMapping(path ="{id}")
    public ResponseEntity<HealthcareProfessional> update(@PathVariable Long id, HealthcareProfessional healthcareProfessional) {
        
        this.healthcareProfessionalService.updateHealthcareProfessional(healthcareProfessional);

        return ResponseEntity.ok(healthcareProfessional);    
    }

    @DeleteMapping(path ="{id}")
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.ok(healthcareProfessionalService.deleteHealthcareProfessional(id));       
    }

    
}