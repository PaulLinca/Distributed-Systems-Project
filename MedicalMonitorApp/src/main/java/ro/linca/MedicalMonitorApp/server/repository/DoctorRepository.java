package ro.linca.MedicalMonitorApp.server.repository;

import ro.linca.MedicalMonitorApp.server.domain.Doctor;

import javax.transaction.Transactional;

@Transactional
public interface DoctorRepository extends BaseUserRepository<Doctor>
{
}
