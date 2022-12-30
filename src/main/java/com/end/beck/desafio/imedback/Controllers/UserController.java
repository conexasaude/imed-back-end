package com.end.beck.desafio.imedback.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.end.beck.desafio.imedback.Repository.UserRepository;

@RestController
@RequestMapping(params = "/user")
public class UserController {
    @Autowired
    private final UserRepository userRepository;

   
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path="/list")
    public ResponseEntity <List<User>> getAllPatient() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @GetMapping(path="/{id}")
    public Optional<User> getPatientbyId(@PathVariable Long id) {
        return this.userRepository.findById(id);
    }
   
    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<User> addNewPatient(User user) {
              
        return ResponseEntity.ok(this.userRepository.save(user));
    }

  
    @PutMapping(path ="/edit/{id}")
    public User updatePatientbyId(User user) {
       
        this.userRepository.save(user);
        return user;    
    }

    @DeleteMapping(path ="/delete/{id}")
    public String deletePatient(User user) {
        this.userRepository.deleteById(user.getId());
        return "paciente " + user.getId() + " deletado com sucesso";
    }
    
}
