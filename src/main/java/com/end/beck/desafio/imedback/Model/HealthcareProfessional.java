package com.end.beck.desafio.imedback.Model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "health_care_professional")
public class HealthcareProfessional {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String name;
    
    @Column(name = "date_created")
    private ZonedDateTime createdDate;

}
