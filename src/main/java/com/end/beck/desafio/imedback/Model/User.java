package com.end.beck.desafio.imedback.Model;


import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User implements UserDetails {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;    
    
    @Column(name = "user_name",unique =  true)
    private String username;
    
    @Column
    private String password;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_permission", 
        joinColumns = {
            @JoinColumn(name = "id_user")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "id_permission")
        }
    )    
    private List<Permission> permissions;
 
    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for (Permission permission : permissions) {
            roles.add(permission.getDescription());
        }
        return roles;
    }
  
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  this.permissions;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked(){
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
      
}
