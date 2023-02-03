package com.end.beck.desafio.imedback.Controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.end.beck.desafio.imedback.Model.Patient;
import com.end.beck.desafio.imedback.Repository.PatientRepository;
import com.end.beck.desafio.imedback.Service.PatientService;
import com.end.beck.desafio.imedback.Service.Impl.PatientServiceImpl;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = PatientController.class)
public class PatientControllerTest {
    
    @Mock
    PatientRepository patientRepository;

    @Mock
    PatientService patientService;

    @Mock
    PatientServiceImpl patientServiceImpl;

    @Test
    public void shouldFindAllPatient() {
        
        List<Patient> listPatient = new ArrayList<>();
        Patient p1 = new Patient();
        Patient p2 = new Patient();

        listPatient.add(p1);
        listPatient.add(p2);

        when(this.patientRepository.findAll()).thenReturn(listPatient);              
        
    }
    
    @Test
    public void should() {
        
    }
    
}
