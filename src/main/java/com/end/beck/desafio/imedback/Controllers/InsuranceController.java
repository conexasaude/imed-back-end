package com.end.beck.desafio.imedback.Controllers;

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

import com.end.beck.desafio.imedback.Mapper.InsuranceMapper;
import com.end.beck.desafio.imedback.Model.Insurance;
import com.end.beck.desafio.imedback.Model.DTO.InsuranceDTO;
import com.end.beck.desafio.imedback.Service.InsuranceService;

@RequestMapping
@RestController(value = "/insurance")
public class InsuranceController {
    
   
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public void findAll() {
        this.insuranceService.findAll();
    }

    @GetMapping(path="/{id}")
    public void findById(@PathVariable Long id, InsuranceDTO insuranceDTO) {
        Insurance insurance = InsuranceMapper.convertToEntity(insuranceDTO);
        this.insuranceService.findById(id, insurance);
    }
   
    @PostMapping
    @ResponseBody
    public void create(InsuranceDTO insuranceDTO) {
        Insurance insurance = InsuranceMapper.convertToEntity(insuranceDTO);       
       this.insuranceService.create(insurance);
    }
  
    @PutMapping(path ="/{id}")
    public void update(@PathVariable Long id, InsuranceDTO insuranceDTO) {
        Insurance insurance = InsuranceMapper.convertToEntity(insuranceDTO);       
        this.insuranceService.update(insurance);
    }

    @DeleteMapping(path ="/{id}")
    public void delete(Long id) {
        this.insuranceService.delete(id);
    }

}
