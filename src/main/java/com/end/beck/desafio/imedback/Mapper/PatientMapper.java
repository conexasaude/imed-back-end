package com.end.beck.desafio.imedback.Mapper;

import org.modelmapper.ModelMapper;

import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientDTO;

public class PatientMapper {
    
    private PatientMapper() { }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Patient convertToEntity(PatientDTO patientDTO){
        return modelMapper.map(patientDTO, Patient.class);
    }

    public static PatientDTO convertToDTO(Patient patient){
        return modelMapper.map(patient, PatientDTO.class);
    }    

}
