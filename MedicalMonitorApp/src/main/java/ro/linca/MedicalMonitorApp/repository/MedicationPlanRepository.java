package ro.linca.MedicalMonitorApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.linca.MedicalMonitorApp.domain.MedicationPlan;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Long>
{
}
