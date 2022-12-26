package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.User;


public interface UserRepository extends JpaRepository<User , Long> {
    
    User findByUsername(String username);
}
