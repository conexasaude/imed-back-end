package com.end.beck.desafio.imedback.Service.Impl;

import com.end.beck.desafio.imedback.Service.InsuranceService;
import com.end.beck.desafio.imedback.Repository.InsuranceRepository;

public class InsuranceServiceImpl implements InsuranceService {
    
    private InsuranceRepository insuranceRepository;

    public List getAllInsurances() {
        this.insuranceRepository.findAll();
    }
    
}
