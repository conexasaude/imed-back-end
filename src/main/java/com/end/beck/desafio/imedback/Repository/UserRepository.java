package com.end.beck.desafio.imedback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.end.beck.desafio.imedback.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    @Query(value="SELECT * FROM users WHERE id = :id", nativeQuery= true )
    public Long findUserById(Long id);

    public User findByUsername(String username);
    
}
