package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.linca.MedicalMonitorApp.domain.Caregiver;
import ro.linca.MedicalMonitorApp.helper.CustomExceptions.NotFoundException;
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

    @GetMapping("/{id}")
    public Caregiver getById(@PathVariable Long id)
    {
        return caregiverRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/")
    public Caregiver createCaregiver(@RequestBody Caregiver newCaregiver)
    {
        return caregiverRepository.save(newCaregiver);
    }

    @PutMapping("/{id}")
    public Caregiver updateCaregiver(@RequestBody Caregiver updatedCaregiver, @PathVariable Long id)
    {
        return caregiverRepository.findById(id)
                .map(caregiver ->
                {
                    caregiver.updateCaregiver(updatedCaregiver);
                    return caregiverRepository.save(updatedCaregiver);
                })
                .orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteCaregiver(@PathVariable Long id)
    {
        caregiverRepository.deleteById(id);
    }
}
