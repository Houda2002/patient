package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientMvcApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"hanan",new Date(),false,12));
            patientRepository.save(new Patient(null,"naji",new Date(),false,18));
            patientRepository.save(new Patient(null,"mohammed",new Date(),true,15));
            patientRepository.save(new Patient(null,"salimi",new Date(),false,65));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

}
