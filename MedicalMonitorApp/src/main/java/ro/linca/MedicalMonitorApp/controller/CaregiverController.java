package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.linca.MedicalMonitorApp.domain.Caregiver;
import ro.linca.MedicalMonitorApp.repository.CaregiverRepository;

import java.util.List;

@RestController
@RequestMapping("caregiver")
public class CaregiverController
{
    @Autowired
    private CaregiverRepository caregiverRepository;

    @GetMapping("/all")
    public List<Caregiver> getAllCaregivers()
    {
        return caregiverRepository.findAll();
    }
}
