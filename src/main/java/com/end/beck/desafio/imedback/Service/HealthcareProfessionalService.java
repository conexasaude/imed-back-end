package com.end.beck.desafio.imedback.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;

@Service
public interface HealthcareProfessionalService {
    
   List<HealthcareProfessional> findAll();

    public HealthcareProfessional findById (Long id, HealthcareProfessional healthcareProfessional);

    public HealthcareProfessional create(HealthcareProfessional healthcareProfessional);

    public HealthcareProfessional update(HealthcareProfessional healthcareProfessional);

    public String delete(Long id);
 
}
