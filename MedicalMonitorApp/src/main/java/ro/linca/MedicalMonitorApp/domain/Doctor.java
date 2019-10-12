package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Doctor extends User
{
    private String medicalField;
}
