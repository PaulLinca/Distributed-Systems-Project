package ro.linca.MedicalMonitorApp.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.linca.MedicalMonitorApp.domain.Caregiver;
import ro.linca.MedicalMonitorApp.domain.Doctor;
import ro.linca.MedicalMonitorApp.domain.Drug;
import ro.linca.MedicalMonitorApp.domain.Patient;
import ro.linca.MedicalMonitorApp.repository.CaregiverRepository;
import ro.linca.MedicalMonitorApp.repository.DoctorRepository;
import ro.linca.MedicalMonitorApp.repository.DrugRepository;
import ro.linca.MedicalMonitorApp.repository.PatientRepository;

@Configuration
public class LoadData
{
    Logger logger = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initPatients(PatientRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Patient("patient@mail.com", "password", "Nelu")));
            logger.info("Preloading " + repository.save(new Patient("pati@mail.com", "pw", "Nelly")));
            logger.info("Preloading " + repository.save(new Patient("ptt@mail.com", "p", "Nelutu")));
        };
    }

    @Bean
    CommandLineRunner initDoctors(DoctorRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Doctor("doctor@mail.com", "password", "Doctoru")));
        };
    }

    @Bean
    CommandLineRunner initCaregivers(CaregiverRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Caregiver("care@mail.com", "care", "Care Giver")));
            logger.info("Preloading " + repository.save(new Caregiver("giver@mail.com", "giver", "Giver Care")));
        };
    }

    @Bean
    CommandLineRunner initDrugs(DrugRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Drug("Paracetamol", 100)));
            logger.info("Preloading " + repository.save(new Drug("Nurofen", 400)));
        };
    }
}
