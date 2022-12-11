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
@Entity
public class Patient implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;
    
    @Column(name = "date_created")
    private ZonedDateTime dateCreated;

    //total de consulta
    @Column(name = "total_appointment")
    private int totalAppointment;

    @Column(name = "online_status")
    private String onlineStatus; 



}
