package com.end.beck.desafio.imedback.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Insurance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    
    @Column
    private String cnpj;
    
    @Column
    private long price;
    
}
