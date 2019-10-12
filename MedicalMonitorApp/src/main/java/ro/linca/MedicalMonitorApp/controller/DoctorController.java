package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.linca.MedicalMonitorApp.domain.Doctor;
import ro.linca.MedicalMonitorApp.domain.User;
import ro.linca.MedicalMonitorApp.repository.BaseUserRepository;
import ro.linca.MedicalMonitorApp.repository.DoctorRepository;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController
{
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }
}
