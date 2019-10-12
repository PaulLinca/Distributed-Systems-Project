package ro.linca.MedicalMonitorApp.repository;

import ro.linca.MedicalMonitorApp.domain.Patient;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

@Transactional
public interface PatientRepository extends BaseUserRepository<Patient>
{
}
