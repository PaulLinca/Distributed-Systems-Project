package ro.linca.MedicalMonitorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.linca.MedicalMonitorApp.domain.Drug;
import ro.linca.MedicalMonitorApp.repository.DrugRepository;

import java.util.List;

@RestController
@RequestMapping("drug")
public class DrugController
{
    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/all")
    public List<Drug> getAllDrugs()
    {
        return drugRepository.findAll();
    }
}
