package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Caregiver extends User
{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "caregiver_id")
    private Set<Patient> patients;

    public Caregiver(String email, String password, String name)
    {
        super(email, password, name);
    }

    public void updateCaregiver(Caregiver caregiver)
    {
        setUserId(caregiver.userId);
        setEmail(caregiver.email);
        setPassword(caregiver.password);
        setName(caregiver.name);
        setPatients(caregiver.patients);
    }
}
