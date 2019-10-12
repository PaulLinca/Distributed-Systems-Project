package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class MedicationPlan
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long medicationPlanId;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private Set<Prescription> prescriptions;
}
