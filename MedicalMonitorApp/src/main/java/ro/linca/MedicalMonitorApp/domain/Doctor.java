package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Doctor extends User
{
    private String medicalField;

    public Doctor(String email, String password, String name)
    {
        super(email, password, name);
    }

    public Doctor(String email, String password, String name, String medicalField)
    {
        super(email, password, name);

        setMedicalField(medicalField);
    }
}
