package ro.linca.MedicalMonitorApp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.linca.MedicalMonitorApp.server.domain.User;

@NoRepositoryBean
public interface BaseUserRepository<T extends User> extends JpaRepository<T, Long>
{
}
