package com.end.beck.desafio.imedback.Service;

import org.springframework.beans.factory.xml.PluggableSchemaResolver;

import com.end.beck.desafio.imedback.Model.Attendance;

public interface AttendanceService {
    public void existsAttendance(Attendance attendance);
}
