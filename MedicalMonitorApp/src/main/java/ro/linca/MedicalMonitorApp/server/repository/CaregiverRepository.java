package ro.linca.MedicalMonitorApp.server.repository;

import ro.linca.MedicalMonitorApp.server.domain.Caregiver;

import javax.transaction.Transactional;

@Transactional
public interface CaregiverRepository extends BaseUserRepository<Caregiver>
{
}
