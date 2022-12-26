package com.end.beck.desafio.imedback.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;


@Data
@Entity
public class Permission implements Serializable, GrantedAuthority{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
   
    @Column
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }    
}
