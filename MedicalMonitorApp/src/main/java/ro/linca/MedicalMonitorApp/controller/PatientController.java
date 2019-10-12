package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.linca.MedicalMonitorApp.domain.Patient;
import ro.linca.MedicalMonitorApp.helper.CustomExceptions.NotFoundException;
import ro.linca.MedicalMonitorApp.repository.PatientRepository;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController
{
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all")
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id)
    {
        return patientRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/")
    public Patient createPatient(@RequestBody Patient newPatient)
    {
        return patientRepository.save(newPatient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@RequestBody Patient updatedPatient, @PathVariable Long id)
    {
        return patientRepository.findById(id)
                .map(patient ->
                {
                    patient.updatePatient(updatedPatient);
                    return patientRepository.save(updatedPatient);
                })
                .orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id)
    {
        patientRepository.deleteById(id);
    }
}
