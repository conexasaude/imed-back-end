package com.end.beck.desafio.imedback.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.Insurance;

@Service
public interface InsuranceService  {
    
    public List<Insurance> findAll();

    public Insurance findById(Long id, Insurance insurance);
    
    public Insurance create(Insurance insurance);

    public Insurance update (Insurance insurance);
    
    public String delete(Long id);    
    
    
}
