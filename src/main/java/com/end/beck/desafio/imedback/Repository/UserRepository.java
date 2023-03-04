package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.end.beck.desafio.imedback.Model.User;

public interface UserRepository extends JpaRepository<User , Long> {

    public User findByUsername(String username);

    Page<User> findAll(Pageable pageable);
    
}
