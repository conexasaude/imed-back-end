package com.end.beck.desafio.imedback.Model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Attendance implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
     
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @OneToOne
    private Patient patient;

    @JoinColumn(name = "healthcare_professional_id", referencedColumnName = "id")
    @OneToOne
    private HealthcareProfessional healthcareProfessional;
    
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private ZonedDateTime starDateTime;
    
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private ZonedDateTime endDateTime;



}
