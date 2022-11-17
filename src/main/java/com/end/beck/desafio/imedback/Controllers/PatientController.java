package com.end.beck.desafio.imedback.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @GetMapping(value="list")
    public String getMethodName() {
        return "rota Get";
    }

    @PostMapping(value="create")
    public String postMethodName() {
        return "rota Post";
    }

    @PutMapping(value="edit")
    public String PutMethodName() {
        return "rota Put";
    }

    @DeleteMapping(value="delete")
    public String deleteMethodName() {
        return "rota Delete";
    }
    
}
