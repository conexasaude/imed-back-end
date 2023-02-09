package com.end.beck.desafio.imedback.Service.Impl;

import com.end.beck.desafio.imedback.Service.InsuranceService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Insurance;
import com.end.beck.desafio.imedback.Repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    
    private InsuranceRepository insuranceRepository;

    public List<Insurance> findAllInsurances() {
        return this.insuranceRepository.findAll();
    }

    public Long getInsuranceById(Long id){
        return insuranceRepository.findInsuranceById(id);
    }
    
    public Insurance create(Insurance insurance) {
        return this.insuranceRepository.save(insurance);
    }

    public Insurance update(Insurance insurance) {
        
        insurance.setName(insurance.getName());
        insurance.setCnpj(insurance.getCnpj());
        insurance.setPrice(insurance.getPrice());

        return this.insuranceRepository.save(insurance);
    }

    public String delete(Long id) {
        try {
            this.insuranceRepository.deleteById(id);
                                    
            return "deletado "+ id +" com sucesso";
        } catch (Exception e) {
           return e + "erro ao deletar Convênio";
        }
    }

    
}
