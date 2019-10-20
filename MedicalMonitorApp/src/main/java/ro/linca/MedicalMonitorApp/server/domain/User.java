package ro.linca.MedicalMonitorApp.server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;
    protected String email;
    protected String password;
    protected String name;

    public User(String email, String password, String name)
    {
        setEmail(email);
        setPassword(password);
        setName(name);
    }
}
