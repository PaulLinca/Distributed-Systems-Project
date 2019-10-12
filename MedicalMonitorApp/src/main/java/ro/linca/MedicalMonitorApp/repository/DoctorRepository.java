package ro.linca.MedicalMonitorApp.repository;

import ro.linca.MedicalMonitorApp.domain.Doctor;

import javax.transaction.Transactional;

@Transactional
public interface DoctorRepository extends BaseUserRepository<Doctor>
{
}
