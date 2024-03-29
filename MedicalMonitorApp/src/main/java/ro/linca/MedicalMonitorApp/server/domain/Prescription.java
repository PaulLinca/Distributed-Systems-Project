package ro.linca.MedicalMonitorApp.server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Prescription implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn
    private Drug drug;
    @Id
    @ManyToOne
    @JoinColumn
    private MedicationPlan plan;
    private Date startDate;
    private Date endDate;
}
