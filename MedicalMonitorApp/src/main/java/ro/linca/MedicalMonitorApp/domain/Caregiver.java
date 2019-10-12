package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Caregiver extends User
{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "caregiver_id")
    private Set<Patient> patients;
}
