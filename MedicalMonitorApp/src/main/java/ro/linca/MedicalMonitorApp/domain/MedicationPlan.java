package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class MedicationPlan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long medicationPlanId;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private Set<Prescription> prescriptions;
}
