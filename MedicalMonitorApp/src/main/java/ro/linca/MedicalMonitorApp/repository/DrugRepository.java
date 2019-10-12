package ro.linca.MedicalMonitorApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.linca.MedicalMonitorApp.domain.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long>
{
}
