package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;
import com.end.beck.desafio.imedback.Repository.HealthcareProfessionalRepository;
import com.end.beck.desafio.imedback.Service.HealthcareProfessionalService;

public class HealthcareProfessionalServiceImpl implements HealthcareProfessionalService {

    @Autowired
    private HealthcareProfessionalRepository healthcareProfessionalRepository;

    public HealthcareProfessionalServiceImpl(HealthcareProfessionalRepository healthcareProfessionalRepository) {
        
        this.healthcareProfessionalRepository = healthcareProfessionalRepository;
    }

    public List<HealthcareProfessional> getAllHealthcareProfessionals() {
        
        return this.healthcareProfessionalRepository.findAll();
    }

    public Optional<HealthcareProfessional> getHealthcareProfessionalById (Long id) {

        return this.healthcareProfessionalRepository.findById(id);
    }

    public HealthcareProfessional createHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
               
        return this.healthcareProfessionalRepository.save(healthcareProfessional);
    }

    public HealthcareProfessional updateHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
        healthcareProfessional.setName(healthcareProfessional.getName());
        healthcareProfessional.setCrm(healthcareProfessional.getCrm());
       
        return this.healthcareProfessionalRepository.save(healthcareProfessional);
    }

    public String deleteHealthcareProfessional(Long id) throws Exception{
        
        try {
            this.healthcareProfessionalRepository.deleteById(id);
                        
            return "deletado com"+ id +" sucesso";
        } catch (Exception e) {
            throw new Exception("atendimento não econtrodado", e);
        }
    }
    
    
}
