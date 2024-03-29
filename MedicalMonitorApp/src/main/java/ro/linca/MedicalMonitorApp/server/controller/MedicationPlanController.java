package ro.linca.MedicalMonitorApp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.linca.MedicalMonitorApp.server.domain.MedicationPlan;
import ro.linca.MedicalMonitorApp.server.helper.CustomExceptions.NotFoundException;
import ro.linca.MedicalMonitorApp.server.repository.MedicationPlanRepository;

import java.util.List;

@RestController
@RequestMapping("plans")
public class MedicationPlanController
{
    @Autowired
    private MedicationPlanRepository medicationPlanRepository;

    @GetMapping("/")
    public List<MedicationPlan> getAllMedicationPlans()
    {
        return medicationPlanRepository.findAll();
    }

    @GetMapping("/{id}")
    public MedicationPlan getById(@PathVariable Long id)
    {
        return medicationPlanRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/")
    public MedicationPlan createMedicationPlan(@RequestBody MedicationPlan newMedicationPlan)
    {
        return medicationPlanRepository.save(newMedicationPlan);
    }

    @PutMapping("/{id}")
    public MedicationPlan updateMedicationPlan(@RequestBody MedicationPlan updatedMedicationPlan, @PathVariable Long id)
    {
        return medicationPlanRepository.findById(id)
                .map(medicationPlan ->
                {
                    medicationPlan.updateMedicationPlan(updatedMedicationPlan);
                    return medicationPlanRepository.save(updatedMedicationPlan);
                })
                .orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicationPlan(@PathVariable Long id)
    {
        medicationPlanRepository.deleteById(id);
    }
}
