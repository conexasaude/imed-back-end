package com.end.beck.desafio.imedback.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Insurance;

@Service
public interface InsuranceService  {
    
    public List<Insurance> findAllInsurances();

    public Long getInsuranceById(Long id);
    
    public Insurance create(Insurance insurance);

    public Insurance update (Insurance insurance);
    
    public void delete(Long id);    
    
    
}
