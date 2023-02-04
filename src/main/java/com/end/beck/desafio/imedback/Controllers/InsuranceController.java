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
import com.end.beck.desafio.imedback.Service.InsuranceService;

@RequestMapping
@RestController(value = "/insurance")
public class InsuranceController {
    
    @Autowired
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping(path="/insurances")
    public ResponseEntity <List<Insurance>> getAllInsurance() {
        return ResponseEntity.ok(this.insuranceService.findAllInsurances());
    }

    @GetMapping(path="/{id}")
    public Long findOne(@PathVariable Long id) {
        return this.insuranceService.getInsuranceById(id);
    }
   
    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<Insurance> create(Insurance insurance) {
               
        return ResponseEntity.ok(this.insuranceService.create(insurance));
    }
  
    @PutMapping(path ="/{id}")
    public Insurance update(Insurance insurance) {
       
        this.insuranceService.update(insurance);
        return insurance;    
    }

    @DeleteMapping(path ="/{id}")
    public String delete(Long id) {
        this.insuranceService.delete(id);
        return "paciente " + id + " deletado com sucesso";
    }

}
