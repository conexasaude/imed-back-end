package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Model.DTO.PatientAttendanceDTO;
import com.end.beck.desafio.imedback.Repository.PatientRepository;
import com.end.beck.desafio.imedback.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

   
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Page<Patient> findAll(int page,int size) {

        Pageable pageResult = PageRequest.of(page, size);

        return this.patientRepository.findAll(pageResult);
    }

    public Patient findById(Long id, Patient patient) {
        this.patientRepository.findById(id);
        return patient;
    }

    public Patient create(Patient patient) {
        return this.patientRepository.save(patient);
    }

    public Patient update(Patient patient) {
        
        patient.setName(patient.getName());
        patient.setOnlineStatus(patient.getOnlineStatus());
        patient.setTotalAppointment(patient.getTotalAppointment());        

        return this.patientRepository.save(patient);
    }

    public String delete(Long id) {
        
        try {
            
            if (null != id) {
                this.patientRepository.deleteById(id);
            }    
                                    
            return "deletado "+ id +" com sucesso";
        } catch (Exception e) {
           return e + "erro ao deletar paciente";
        }
    }

    public PatientAttendanceDTO verificationAttendanceByConfirmation(PatientAttendanceDTO patientAttendanceDTO) throws RuntimeException {
        
        try{

            if(patientAttendanceDTO.isConfirmationAttendance() == false){
                throw new RuntimeException("Não possui nenhum atendimento confirmado");
            }

            patientAttendanceDTO.getAttendance().getId();
            patientAttendanceDTO.getAttendance().getStarDateTime();
            patientAttendanceDTO.getHealthcareProfessional();   

            return patientAttendanceDTO;
        }catch(RuntimeException ex){
            throw new RuntimeException("Erro ao encontrar Atendimento confirmado do paciente");
        }
    
    }
  
}
