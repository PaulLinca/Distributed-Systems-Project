package ro.linca.MedicalMonitorApp.server.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.linca.MedicalMonitorApp.server.domain.Caregiver;
import ro.linca.MedicalMonitorApp.server.domain.Doctor;
import ro.linca.MedicalMonitorApp.server.domain.Drug;
import ro.linca.MedicalMonitorApp.server.domain.Patient;
import ro.linca.MedicalMonitorApp.server.repository.CaregiverRepository;
import ro.linca.MedicalMonitorApp.server.repository.DoctorRepository;
import ro.linca.MedicalMonitorApp.server.repository.DrugRepository;
import ro.linca.MedicalMonitorApp.server.repository.PatientRepository;

import java.util.Date;

@Configuration
public class LoadData
{
    Logger logger = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initPatients(PatientRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Patient("cristi@mail.com", "password", "Cristian Cristi", new Date(1000), "Male", "Address 1")));
            logger.info("Preloading " + repository.save(new Patient("nf@mail.com", "password", "Nelly F", new Date(1000), "Female", "Address 2")));
            logger.info("Preloading " + repository.save(new Patient("ptt@mail.com", "password", "Inca Un Pacient", new Date(4543), "Male", "Address 3")));
            logger.info("Preloading " + repository.save(new Patient("mail@mail.com", "password", "Inca Un Pacient", new Date(1340), "Female", "Address 4")));
            logger.info("Preloading " + repository.save(new Patient("mailul@mail.com", "password", "Pacientul Pacient", new Date(100440), "Female", "Address 5")));
            logger.info("Preloading " + repository.save(new Patient("mailmail@mail.com", "password", "Pacient Sss", new Date(2), "Male", "Address 6")));
        };
    }

    @Bean
    CommandLineRunner initDoctors(DoctorRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Doctor("doctor@mail.com", "password", "Dorian Pop", "Dentistry")));
            logger.info("Preloading " + repository.save(new Doctor("Nelutu@mail.com", "password", "Nelu Porumbel", "Pharmacy")));
            logger.info("Preloading " + repository.save(new Doctor("altu@mail.com", "password", "Alt Doctor", "Dentistry")));
            logger.info("Preloading " + repository.save(new Doctor("popopop@mail.com", "password", "Pop Popescu", "Dermatology")));
            logger.info("Preloading " + repository.save(new Doctor("dorin@mail.com", "password", "Popa Dorin", "General Medicine")));
            logger.info("Preloading " + repository.save(new Doctor("mai@mail.com", "password", "Mai Baga", "Allergology")));
            logger.info("Preloading " + repository.save(new Doctor("doctor444@mail.com", "password", "Negru Dan", "Gastroenterology")));
            logger.info("Preloading " + repository.save(new Doctor("damasc@mail.com", "password", "Danesc", "Pharmacy")));
            logger.info("Preloading " + repository.save(new Doctor("altii@mail.com", "password", "Det Net", "Psychiatry")));
            logger.info("Preloading " + repository.save(new Doctor("laptop@mail.com", "password", "Acer Dell", "Dermatology")));
            logger.info("Preloading " + repository.save(new Doctor("ce@mail.com", "password", "Nu Mai Stiu Nume", "Optometry")));
            logger.info("Preloading " + repository.save(new Doctor("doctorel@mail.com", "password", "Doctor", "Nutrition")));
        };
    }

    @Bean
    CommandLineRunner initCaregivers(CaregiverRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Caregiver("care@mail.com", "password", "Care Giver")));
            logger.info("Preloading " + repository.save(new Caregiver("giver@mail.com", "password", "Giver Care")));
        };
    }

    @Bean
    CommandLineRunner initDrugs(DrugRepository repository)
    {
        return args ->
        {
            logger.info("Preloading " + repository.save(new Drug("Paracetamol", 100)));
            logger.info("Preloading " + repository.save(new Drug("Nurofen", 200)));
            logger.info("Preloading " + repository.save(new Drug("Nurofen Forte", 400)));
            logger.info("Preloading " + repository.save(new Drug("Augmentin", 500)));
            logger.info("Preloading " + repository.save(new Drug("Fortifikat Forte", 200)));
            logger.info("Preloading " + repository.save(new Drug("Codeina", 420)));
            logger.info("Preloading " + repository.save(new Drug("Ceva pentru burta", 300)));
        };
    }
}
