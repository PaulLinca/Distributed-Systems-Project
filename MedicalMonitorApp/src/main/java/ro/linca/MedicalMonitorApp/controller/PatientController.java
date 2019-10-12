package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.linca.MedicalMonitorApp.domain.Doctor;
import ro.linca.MedicalMonitorApp.domain.Patient;
import ro.linca.MedicalMonitorApp.repository.PatientRepository;

import java.util.List;

@RestController
public class PatientController
{
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }
}
