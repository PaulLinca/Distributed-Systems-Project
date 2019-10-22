package ro.linca.MedicalMonitorApp.server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Patient extends User
{
    private String birthDate;
    private String gender;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medication_plan_id")
    private MedicationPlan medicationPlan;

    public Patient(String email, String password, String name)
    {
        super(email, password, name);
    }

    public Patient(String email, String password, String name, String birthDate, String gender, String address)
    {
        super(email, password, name);

        setBirthDate(birthDate);
        setGender(gender);
        setAddress(address);
    }

    public void updatePatient(Patient updatedPatient)
    {
        if(this.userId != updatedPatient.userId)
        {
            return;
        }
        setEmail(updatedPatient.email);
        setPassword(updatedPatient.password);
        setName(updatedPatient.name);
        setBirthDate(updatedPatient.birthDate);
        setGender(updatedPatient.gender);
        setAddress(updatedPatient.address);
        setMedicationPlan(updatedPatient.medicationPlan);
    }
}
