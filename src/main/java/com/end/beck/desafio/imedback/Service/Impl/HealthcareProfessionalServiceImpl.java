package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;
import com.end.beck.desafio.imedback.Repository.HealthcareProfessionalRepository;
import com.end.beck.desafio.imedback.Service.HealthcareProfessionalService;

@Service
public class HealthcareProfessionalServiceImpl implements HealthcareProfessionalService {

    
    private HealthcareProfessionalRepository healthcareProfessionalRepository;

    public HealthcareProfessionalServiceImpl(HealthcareProfessionalRepository healthcareProfessionalRepository) {
       this.healthcareProfessionalRepository = healthcareProfessionalRepository;
    }

    public List<HealthcareProfessional> findAll() {
        return this.healthcareProfessionalRepository.findAll();
    }

    public HealthcareProfessional findById(Long id, HealthcareProfessional healthcareProfessional) {
        this.healthcareProfessionalRepository.findById(id);
        return healthcareProfessional;
    }

    public HealthcareProfessional create(HealthcareProfessional healthcareProfessional) {               
        return this.healthcareProfessionalRepository.save(healthcareProfessional);
    }

    public HealthcareProfessional update(HealthcareProfessional healthcareProfessional) {
        healthcareProfessional.setName(healthcareProfessional.getName());
        healthcareProfessional.setCrm(healthcareProfessional.getCrm());
       
        return this.healthcareProfessionalRepository.save(healthcareProfessional);
    }

    public String delete(Long id) {
        
        try {
            this.healthcareProfessionalRepository.deleteById(id);
                        
            return "deletado com"+ id +" sucesso";
        } catch (Exception e) {
           return e + "erro ao deletar profissional";
        }
    }
    
    
}
