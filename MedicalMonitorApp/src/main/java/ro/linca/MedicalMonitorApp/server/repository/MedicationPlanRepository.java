package ro.linca.MedicalMonitorApp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.linca.MedicalMonitorApp.server.domain.MedicationPlan;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Long>
{
}
