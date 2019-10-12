package ro.linca.MedicalMonitorApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Patient extends User
{
    private Date birthDate;
    private String gender;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private MedicationPlan medicationPlan;

    public Patient(String email, String password, String name)
    {
        super(email, password, name);
    }

    public Patient(String email, String password, String name, Date birthDate, String gender, String address)
    {
        super(email, password, name);

        setBirthDate(birthDate);
        setGender(gender);
        setAddress(address);
    }

    public void updatePatient(Patient patient)
    {
        setUserId(patient.userId);
        setEmail(patient.email);
        setPassword(patient.password);
        setName(patient.name);
        setBirthDate(patient.birthDate);
        setGender(patient.gender);
        setAddress(patient.address);
    }
}
