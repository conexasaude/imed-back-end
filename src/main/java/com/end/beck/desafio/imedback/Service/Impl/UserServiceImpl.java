package com.end.beck.desafio.imedback.Service.Impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
    
    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    
    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("finding one user by name  " + username + "!");
        var user = userRepository.findByUsername(username);
        if (null != user) {
            return user;            
        } else {
            throw new UsernameNotFoundException("username"+ username +" não encontrando");
        }
      
    }

}
