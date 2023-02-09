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

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController{
    
    
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping(path="/attendances")
    public ResponseEntity <List<Attendance>> getAllAttendance() {
        return ResponseEntity.ok(this.attendanceService.getAllAttendance());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Long> getAttendancebyId(@PathVariable Long id) {
        return ResponseEntity.ok(this.attendanceService.getAttendanceById(id));
    }
   
    @PostMapping(path="/attendance")
    @ResponseBody
    public ResponseEntity<Attendance> create(Attendance attendance) {                
        return ResponseEntity.ok(this.attendanceService.create(attendance));
    }
  
    @PutMapping(path ="/{id}")
    public ResponseEntity<Attendance> update( @PathVariable Long id, Attendance attendance) {
       
        this.attendanceService.update(attendance);
        
        return ResponseEntity.ok(attendance);    
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
       return ResponseEntity.ok(this.attendanceService.delete(id));            
        
    }

}
