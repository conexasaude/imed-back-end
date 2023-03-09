package com.end.beck.desafio.imedback.Model.DTO;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class HealthcareProfessionalDTO {
  
    private Long id;
    private String name;
    private ZonedDateTime createdDate;
    private String status;
    private String rating;
    private String crm;

}
