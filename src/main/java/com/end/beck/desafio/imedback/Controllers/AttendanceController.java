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
import com.end.beck.desafio.imedback.Repository.AttendanceRepository;



@RestController
@RequestMapping("/attendance")
public class AttendanceController{
    
    @Autowired
    private final AttendanceRepository attendanceRepository;

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping(path="/list")
    public ResponseEntity <List<Attendance>> getAllAttendace() {
        return ResponseEntity.ok(this.attendanceRepository.findAll());
    }

    @GetMapping(path="/{id}")
    public Optional<Attendance> getAttendancebyId(@PathVariable Attendance attendance) {
        return this.attendanceRepository.findById(attendance.getId());
    }
   
    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<Attendance> addNewAttendance(Attendance attendance) {
        
        attendance.setStarDateTime(attendance.getStarDateTime());
        attendance.setEndDateTime(attendance.getEndDateTime());
                
        return ResponseEntity.ok(this.attendanceRepository.save(attendance));
    }

  
    @PutMapping(path ="/edit/{id}")
    public Attendance updateAttendancebyId(Attendance attendance) {
       
        this.attendanceRepository.save(attendance);
        return attendance;    
    }

    @DeleteMapping(path ="/delete/{id}")
    public String deleteAttendance(@PathVariable Attendance attendance) {
        this.attendanceRepository.deleteById(attendance.getId());
        return "atendimento " + attendance + " deletado com sucesso";
    }

}
