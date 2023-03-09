package com.end.beck.desafio.imedback.Mapper;

import org.modelmapper.ModelMapper;

import com.end.beck.desafio.imedback.Model.Insurance;
import com.end.beck.desafio.imedback.Model.DTO.InsuranceDTO;

public class InsuranceMapper {
    
    private InsuranceMapper() { }
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public static final Insurance convertToEntity(InsuranceDTO insuranceDTO){
        return modelMapper.map(insuranceDTO, Insurance.class);
    }

    public static final InsuranceDTO convertToDTO (Insurance insurance){
        return modelMapper.map(insurance, InsuranceDTO.class);
    }
}
