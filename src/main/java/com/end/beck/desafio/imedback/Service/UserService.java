package com.end.beck.desafio.imedback.Service;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Model.User;

@Service
public interface UserService {
    
    public Page<User> findAll(int page, int size);

    public User findById(Long id, User user);

    public User create(User user);

    public User update(User user);
    
    public String delete(Long id);    
}
