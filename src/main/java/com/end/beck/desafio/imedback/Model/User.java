package com.end.beck.desafio.imedback.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class User implements Serializable {
   
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    
    @Column(unique =  true)
    private String user;
    
    @Column
    private String password;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_permission", 
        joinColumns = {@JoinColumn (name = "id_user")},
        inverseJoinColumns = {@JoinColumn(name = "id_permission")}
    )
    private List<Permission> Permission;
      
}
