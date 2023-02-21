package com.end.beck.desafio.imedback.Controllers;

import java.util.List;

import javax.ws.rs.core.Response;

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
import com.end.beck.desafio.imedback.Service.InsuranceService;

@RequestMapping
@RestController(value = "/insurance")
public class InsuranceController {
    
   
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public ResponseEntity <List<Insurance>> findAll() {
        return ResponseEntity.ok(this.insuranceService.findAll());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Insurance> findById(@PathVariable Long id, Insurance insurance) {
        return ResponseEntity.ok(this.insuranceService.findById(id, insurance));
    }
   
    @PostMapping
    @ResponseBody
    public ResponseEntity<Insurance> create(Insurance insurance) {
               
        return ResponseEntity.ok(this.insuranceService.create(insurance));
    }
  
    @PutMapping(path ="/{id}")
    public ResponseEntity<Insurance> update(@PathVariable Long id, Insurance insurance) {
        this.insuranceService.update(insurance);
       
        return ResponseEntity.ok(insurance);    
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.ok(this.insuranceService.delete(id));
        
    }

}
