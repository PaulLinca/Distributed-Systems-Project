package ro.linca.MedicalMonitorApp.domain;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long userId;
    protected String email;
    protected String password;
    protected String name;
}
