package com.end.beck.desafio.imedback.Controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.end.beck.desafio.imedback.Model.Patient;

@ExtendWith(MockitoExtension.class)
public class PatientController {
    
    @InjectMocks
    PatientController patientController;

    @Mock
    Patient patient;
}
