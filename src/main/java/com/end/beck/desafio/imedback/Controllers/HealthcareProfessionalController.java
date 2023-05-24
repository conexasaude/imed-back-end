package com.end.beck.desafio.imedback.Controllers;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.end.beck.desafio.imedback.Mapper.HealthcareProfessionalMapper;
import com.end.beck.desafio.imedback.Model.HealthcareProfessional;
import com.end.beck.desafio.imedback.Model.DTO.HealthcareProfessionalDTO;
import com.end.beck.desafio.imedback.Service.HealthcareProfessionalService;

@RestController
@RequestMapping(path = "/healthcare-professional")
public class HealthcareProfessionalController {    
    
    
    private final HealthcareProfessionalService healthcareProfessionalService;
    
    public HealthcareProfessionalController(HealthcareProfessionalService healthcareProfessionalService) {
        this.healthcareProfessionalService = healthcareProfessionalService;
    }
   
    @GetMapping
    public void findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        this.healthcareProfessionalService.findAll(page,size);
    }

    @GetMapping(path="/{id}")
    public void findOneHealtchcareProfessional(@PathVariable Long id,HealthcareProfessionalDTO healthcareProfessionalDTO) {
      HealthcareProfessional healthcareProfessional = HealthcareProfessionalMapper.convertToEntity(healthcareProfessionalDTO);
        this.healthcareProfessionalService.findById(id,healthcareProfessional);
    }
   
    @PostMapping
    @ResponseBody
    public void create(HealthcareProfessionalDTO healthcareProfessionalDTO) {
        HealthcareProfessional healthcareProfessional = HealthcareProfessionalMapper.convertToEntity(healthcareProfessionalDTO);
        healthcareProfessional.setCreatedDate(ZonedDateTime.now());
        this.healthcareProfessionalService.create(healthcareProfessional);
    }
  
    @PutMapping(path ="{id}")
    public void update(@PathVariable Long id, HealthcareProfessionalDTO healthcareProfessionalDTO) {
        HealthcareProfessional healthcareProfessional = HealthcareProfessionalMapper.convertToEntity(healthcareProfessionalDTO);
        this.healthcareProfessionalService.update(healthcareProfessional);
    }

    @DeleteMapping(path ="{id}")
    public void delete(Long id) {
        healthcareProfessionalService.delete(id);       
    }

    
}