package ro.linca.MedicalMonitorApp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.linca.MedicalMonitorApp.server.domain.Drug;
import ro.linca.MedicalMonitorApp.server.helper.CustomExceptions.NotFoundException;
import ro.linca.MedicalMonitorApp.server.repository.DrugRepository;

import java.util.List;

@RestController
@RequestMapping("drugs")
public class DrugController
{
    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/")
    public List<Drug> getAllDrugs()
    {
        return drugRepository.findAll();
    }

    @GetMapping("/{id}")
    public Drug getById(@PathVariable Long id)
    {
        return drugRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/")
    public Drug createDrug(@RequestBody Drug newDrug)
    {
        return drugRepository.save(newDrug);
    }

    @PutMapping("/{id}")
    public Drug updateDrug(@RequestBody Drug updatedDrug, @PathVariable Long id)
    {
        return drugRepository.findById(id)
                .map(drug ->
                {
                    drug.updateDrug(updatedDrug);
                    return drugRepository.save(updatedDrug);
                })
                .orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteDrugr(@PathVariable Long id)
    {
        drugRepository.deleteById(id);
    }
}
