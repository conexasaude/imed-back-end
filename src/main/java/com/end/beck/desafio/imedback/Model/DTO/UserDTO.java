package com.end.beck.desafio.imedback.Model.DTO;

import java.util.List;

import com.end.beck.desafio.imedback.Model.Permission;

import lombok.Data;

@Data
public class UserDTO {
    
    private Long id;    
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private List<Permission> permissions;
 
}
