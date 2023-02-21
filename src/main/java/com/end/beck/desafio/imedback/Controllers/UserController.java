package com.end.beck.desafio.imedback.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.end.beck.desafio.imedback.Model.User;
import com.end.beck.desafio.imedback.Service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {   

    private final UserService userService;
   
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity <List<User>> findAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id, User user) {
        return ResponseEntity.ok(this.userService.findById(id, user));
    }
   
    @PostMapping
    @ResponseBody
    public ResponseEntity<User> create(User user) {
              
        return ResponseEntity.ok(this.userService.create(user));
    }

  
    @PutMapping(path ="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, User user) {
        this.userService.update(user);
       
        return ResponseEntity.ok(user);    
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.delete(id));        
    }
    
}
