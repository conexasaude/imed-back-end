package com.end.beck.desafio.imedback.Controllers;

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

import com.end.beck.desafio.imedback.Model.Insurance;
import com.end.beck.desafio.imedback.Repository.InsuranceRepository;

@RequestMapping
@RestController(value = "/insurance")
public class InsuranceController {
    
    @Autowired
    private final InsuranceRepository insuranceRepository;

    public InsuranceController(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @GetMapping(path="/list")
    public ResponseEntity <List<Insurance>> getAllInsurance() {
        return ResponseEntity.ok(this.insuranceRepository.findAll());
    }

    @GetMapping(path="/{id}")
    public Optional<Insurance> getPatientbyId(@PathVariable Long id) {
        return this.insuranceRepository.findById(id);
    }
   
    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<Insurance> addNewPatient(Insurance insurance) {
               
        return ResponseEntity.ok(this.insuranceRepository.save(insurance));
    }
  
    @PutMapping(path ="/edit/{id}")
    public Insurance updatePatientbyId(Insurance insurance) {
       
        this.insuranceRepository.save(insurance);
        return insurance;    
    }

    @DeleteMapping(path ="/delete/{id}")
    public String deletePatient(Insurance insurance) {
        this.insuranceRepository.deleteById(insurance.getId());
        return "paciente " + insurance.getId() + " deletado com sucesso";
    }

}
