package com.end.beck.desafio.imedback.Model.DTO;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class PatientDTO {
        
    private Long id;
    private String name;   
    private ZonedDateTime dateCreated;
    private int totalAppointment;  
    private String onlineStatus; 

}
