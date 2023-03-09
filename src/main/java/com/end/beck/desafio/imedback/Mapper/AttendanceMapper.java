package com.end.beck.desafio.imedback.Mapper;

import org.modelmapper.ModelMapper;

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Model.DTO.AttendanceDTO;

public class AttendanceMapper {
    
    private AttendanceMapper(){}

    private static final ModelMapper modelMapper = new ModelMapper();

    public static final Attendance convertToEntity(AttendanceDTO attendanceDTO){
        return modelMapper.map(attendanceDTO, Attendance.class);
    }

    public static final AttendanceDTO convertToDTO (Attendance attendance){
        return modelMapper.map(attendance, AttendanceDTO.class);
    }

}
