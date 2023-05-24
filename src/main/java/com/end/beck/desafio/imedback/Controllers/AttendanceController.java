package com.end.beck.desafio.imedback.Controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.end.beck.desafio.imedback.Mapper.AttendanceMapper;
import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Model.DTO.AttendanceDTO;
import com.end.beck.desafio.imedback.Service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController{
    
    
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity <Page<Attendance>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.attendanceService.findAll(page, size));
    }

    @GetMapping(path="/{id}")
    public void findById(@PathVariable Long id, AttendanceDTO attendanceDTO) {
        Attendance attendance =  AttendanceMapper.convertToEntity(attendanceDTO);
        this.attendanceService.findById(id, attendance);
    }
   
    @PostMapping
    @ResponseBody
    public void create(AttendanceDTO attendanceDTO) {  
        Attendance attendance =  AttendanceMapper.convertToEntity(attendanceDTO);
        this.attendanceService.create(attendance);
    }
  
    @PutMapping(path ="/{id}")
    public void update(@PathVariable Long id, AttendanceDTO attendanceDTO) {
        Attendance attendance =  AttendanceMapper.convertToEntity(attendanceDTO);    
        this.attendanceService.update(attendance);
    }

    @DeleteMapping(path ="/{id}")
    public void delete(@PathVariable Long id){
       this.attendanceService.delete(id);            
    }
    
}
