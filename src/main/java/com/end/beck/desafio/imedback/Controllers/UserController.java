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
@RequestMapping(params = "/user")
public class UserController {   

    private final UserService userService;

   
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/users")
    public ResponseEntity <List<User>> users() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Long> findUser(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }
   
    @PostMapping(path="/user")
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
