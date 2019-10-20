package ro.linca.MedicalMonitorApp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.linca.MedicalMonitorApp.server.domain.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long>
{
}
