package com.end.beck.desafio.imedback.Service;

import java.util.List;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;

public interface HealthcareProfessionalService {
    
   List<HealthcareProfessional> getAllHealthcareProfessional();

    public Long findByHeathcareProfessionalId (Long id);

    public HealthcareProfessional createHealthcareProfessional(HealthcareProfessional healthcareProfessional);

    public HealthcareProfessional updateHealthcareProfessional(HealthcareProfessional healthcareProfessional);

    public String deleteHealthcareProfessional(Long id);
 
}
