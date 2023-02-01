package com.end.beck.desafio.imedback.Model.DTO;

import java.util.Date;

import com.end.beck.desafio.imedback.Model.HealthcareProfessional;
import com.end.beck.desafio.imedback.Model.Patient;

import lombok.Data;


@Data
public class AttendanceDTO {

    private long id;
    private Date startDate;
    private Date endDate;
    private Patient patient;
    private HealthcareProfessional  healthcareProfessional;
        
}