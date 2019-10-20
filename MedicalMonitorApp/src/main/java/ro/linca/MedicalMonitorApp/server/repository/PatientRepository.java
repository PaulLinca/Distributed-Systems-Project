package ro.linca.MedicalMonitorApp.server.repository;

import ro.linca.MedicalMonitorApp.server.domain.Patient;

import javax.transaction.Transactional;

@Transactional
public interface PatientRepository extends BaseUserRepository<Patient>
{
}
