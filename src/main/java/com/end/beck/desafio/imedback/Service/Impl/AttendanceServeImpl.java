package com.end.beck.desafio.imedback.Service.Impl;

import com.end.beck.desafio.imedback.Model.Attendance;
import com.end.beck.desafio.imedback.Service.AttendanceService;

public class AttendanceServeImpl implements AttendanceService {

        
    public void existsAttendance(Attendance attendance) {
        if(checkTime(attendance)){
            throw new RuntimeException("Já possui um atendimento no hórario escolhido");
        }
    }

    private boolean checkTime(Attendance attendance) {
        return attendance.getStarDateTime() != null || attendance.getEndDateTime() != null;
    }
}
