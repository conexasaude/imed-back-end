package com.end.beck.desafio.imedback.Service;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;

@Service
public interface HealthcareProfessionalService {
    
    public Page<HealthcareProfessional> findAll(int page, int size);

    public HealthcareProfessional findById (Long id, HealthcareProfessional healthcareProfessional);

    public HealthcareProfessional create(HealthcareProfessional healthcareProfessional);

    public HealthcareProfessional update(HealthcareProfessional healthcareProfessional);

    public String delete(Long id);
 
}
