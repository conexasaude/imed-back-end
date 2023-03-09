package com.end.beck.desafio.imedback.Mapper;

import org.modelmapper.ModelMapper;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;
import com.end.beck.desafio.imedback.Model.DTO.HealthcareProfessionalDTO;

public class HealthcareProfessionalMapper {
    
    private HealthcareProfessionalMapper(){}

    private static final ModelMapper modelMapper = new ModelMapper();

    public static final HealthcareProfessional convertToEntity(HealthcareProfessionalDTO healthcareProfessionalDTO){
        return modelMapper.map(healthcareProfessionalDTO, HealthcareProfessional.class);
    }

    public static final HealthcareProfessionalDTO convertToDTO (HealthcareProfessional healthcareProfessional){
        return modelMapper.map(healthcareProfessional, HealthcareProfessionalDTO.class);
    }


}
