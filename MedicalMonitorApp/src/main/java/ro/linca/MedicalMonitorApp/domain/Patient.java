package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Patient extends User
{
    private String birthDate;
    private String gender;
    private String address;
}
