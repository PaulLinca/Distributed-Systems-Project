package ro.linca.MedicalMonitorApp.server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Drug
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long drugId;
    private String name;
    private int amountInGrams;
    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
    private Set<Prescription> prescriptions;

    public Drug(String name, int amountInGrams)
    {
        setName(name);
        setAmountInGrams(amountInGrams);
    }

    public void updateDrug(Drug updatedDrug)
    {
        if(this.drugId != updatedDrug.drugId)
        {
            return;
        }
        setName(updatedDrug.name);
        setAmountInGrams(updatedDrug.amountInGrams);
        setPrescriptions(updatedDrug.prescriptions);
    }
}
