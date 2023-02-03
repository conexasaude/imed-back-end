package com.end.beck.desafio.imedback.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PatientTest {


    @Test
    public void shouldPatientNoInformation() {
        Patient patient = new Patient();
        
        assertEquals(null,patient.getId());   
        
    }

    @Test
    public void shouldPatientWithInformation() {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("daniel");
        
        assertEquals(1L,patient.getId()); 
        assertEquals("daniel",patient.getName());   
        
    }

    
}