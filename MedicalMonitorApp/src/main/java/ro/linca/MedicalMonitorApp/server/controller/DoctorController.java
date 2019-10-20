package ro.linca.MedicalMonitorApp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.linca.MedicalMonitorApp.server.domain.Doctor;
import ro.linca.MedicalMonitorApp.server.helper.CustomExceptions.NotFoundException;
import ro.linca.MedicalMonitorApp.server.repository.DoctorRepository;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController
{
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/")
    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id)
    {
        return doctorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/")
    public Doctor createDoctor(@RequestBody Doctor newDoctor)
    {
        return doctorRepository.save(newDoctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@RequestBody Doctor updatedDoctor, @PathVariable Long id)
    {
        return doctorRepository.findById(id)
                .map(doctor ->
                {
                    doctor.updateDoctor(updatedDoctor);
                    return doctorRepository.save(updatedDoctor);
                })
                .orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id)
    {
        doctorRepository.deleteById(id);
    }
}
