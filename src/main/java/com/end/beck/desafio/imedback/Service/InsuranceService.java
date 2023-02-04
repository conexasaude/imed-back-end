package com.end.beck.desafio.imedback.Service;

import java.util.List;

import com.end.beck.desafio.imedback.Model.Insurance;

public interface InsuranceService  {
    
    public List<Insurance> findAllInsurances();

    public Long getInsuranceById(Long id);
    
    public Insurance create(Insurance insurance);

    public Insurance update (Insurance insurance);
    
    public void delete(Long id);    
    
    
}
