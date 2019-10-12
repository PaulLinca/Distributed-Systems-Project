package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Drug
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long drugId;
    private String name;
    private int amountInGrams;
    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
    private Set<Prescription> prescriptions;
}
