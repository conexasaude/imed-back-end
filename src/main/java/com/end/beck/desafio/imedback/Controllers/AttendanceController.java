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

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Model.DTO.AttendanceDTO;
import com.end.beck.desafio.imedback.Repository.AttendanceRepository;
import com.end.beck.desafio.imedback.Service.AttendanceService;



@RestController
@RequestMapping("/attendance")
public class AttendanceController{
     
    @Autowired
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping(path="/all")
    public ResponseEntity <List<Attendance>> getAllAttendance() {
        return ResponseEntity.ok(this.attendanceService.getAllAttendance());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Attendance>> getAttendancebyId(@PathVariable Long id) {
        return ResponseEntity.ok(this.attendanceService.getAttendanceById(id));
    }
   
    @PostMapping(path="/new-attendance")
    @ResponseBody
    public ResponseEntity<Attendance> addNewAttendance(Attendance attendance) {
                               
        return ResponseEntity.ok(this.attendanceService.createAttendance(attendance));
    }
  
    @PutMapping(path ="/{id}")
    public Attendance updateAttendancebyId(Attendance attendance) {
       
        this.attendanceService.updateAttendance(attendance);
        
        return attendance;    
    }

    @DeleteMapping(path ="/{id}")
    public String deleteAttendance(@PathVariable Long id) throws Exception{
        try {
            this.attendanceService.deleteAttendance(id);
            
            return "deletado com"+ id +" sucesso";
        } catch (Exception e) {
            throw new Exception("atendimento não econtrodado", e);
        }
        
    }

}
