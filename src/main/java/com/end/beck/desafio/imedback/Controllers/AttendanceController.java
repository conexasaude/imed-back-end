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
    public ResponseEntity<AttendanceDTO> findById(@PathVariable Long id, Attendance attendance) {

        this.attendanceService.findById(id, attendance);

        return ResponseEntity.ok(AttendanceMapper.convertToDTO(attendance));
    }
   
    @PostMapping
    @ResponseBody
    public ResponseEntity<AttendanceDTO> create(Attendance attendance) {  
        
        this.attendanceService.create(attendance);

        return ResponseEntity.ok(AttendanceMapper.convertToDTO(attendance));
    }
  
    @PutMapping(path ="/{id}")
    public ResponseEntity<AttendanceDTO> update( @PathVariable Long id, Attendance attendance) {
       
        this.attendanceService.update(attendance);
        
        return ResponseEntity.ok(AttendanceMapper.convertToDTO(attendance));    
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
       return ResponseEntity.ok(this.attendanceService.delete(id));            
        
    }
    
}
