package com.end.beck.desafio.imedback.Model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;


@Data
@Entity
public class Permission  implements Serializable{
    
    private long id;
    private String description;    
}
