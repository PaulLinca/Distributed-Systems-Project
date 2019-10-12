package ro.linca.MedicalMonitorApp.repository;

import ro.linca.MedicalMonitorApp.domain.Caregiver;

import javax.transaction.Transactional;

@Transactional
public interface CaregiverRepository extends BaseUserRepository<Caregiver>
{
}
