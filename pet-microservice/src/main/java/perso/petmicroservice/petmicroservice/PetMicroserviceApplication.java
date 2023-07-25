package perso.petmicroservice.petmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "perso.*" }, exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
public class PetMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetMicroserviceApplication.class, args);
	}

}
