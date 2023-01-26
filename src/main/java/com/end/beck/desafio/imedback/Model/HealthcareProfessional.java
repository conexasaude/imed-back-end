package com.end.beck.desafio.imedback.Model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "health_care_professional")
public class HealthcareProfessional implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String name;
    
    @Column(name = "date_created")
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @Column
    private String status;
    
    @Column
    private String rating;

    @Column
    private String crm;
    
}
