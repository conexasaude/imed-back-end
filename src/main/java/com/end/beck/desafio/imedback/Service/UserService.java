package com.end.beck.desafio.imedback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.end.beck.desafio.imedback.Repository.UserRepository;

import lombok.var;

public class UserService  implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }else{

                throw new UsernameNotFoundException("Ursaname" + username + "Não encontrado");
            }
    }


}
