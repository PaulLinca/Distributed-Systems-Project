package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.linca.MedicalMonitorApp.domain.MedicationPlan;
import ro.linca.MedicalMonitorApp.repository.MedicationPlanRepository;

import java.util.List;

@RestController
@RequestMapping("plan")
public class MedicationPlanController
{
    @Autowired
    private MedicationPlanRepository medicationPlanRepository;

    @GetMapping("/all")
    public List<MedicationPlan> getAllMedicationPlans()
    {
        return medicationPlanRepository.findAll();
    }
}
