package com.end.beck.desafio.imedback.Service.Impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.User;
import com.end.beck.desafio.imedback.Repository.UserRepository;
import com.end.beck.desafio.imedback.Service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    
    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAll(int page, int size) {

        Pageable pageResult = PageRequest.of(page, size);

        return this.userRepository.findAll(pageResult);
    }

    public User findById(Long id, User user) {
        this.userRepository.findById(id);
        return user;
    }

    public User create(User user) {
        return this.userRepository.save(user);
    }

    public User update(User user) {
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());

        return this.userRepository.save(user);
    }

    public String delete(Long id) {

        try {

            if (null != id) {
                this.userRepository.deleteById(id);
            }
                        
            return "deletado "+ id +" sucesso";
        } catch (Exception e) {
           return e + "erro ao delete profissional";
        }
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
