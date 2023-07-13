package perso.testmicroservice1.infrastructure.configs.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantRepository;
import perso.testmicroservice1.domain.contracts.replicants.ReplicantService;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepRepository;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepService;
import perso.testmicroservice1.domain.services.DomainReplicantService;
import perso.testmicroservice1.domain.services.DomainElectricSheepService;

@Configuration
public class BeanConfiguration {

	@Bean
	ReplicantService orderService(ReplicantRepository replicantRepository) {
		return new DomainReplicantService(replicantRepository);
	}

	@Bean
	ElectricSheepService productService(ElectricSheepRepository electricSheepRepository) {
		return new DomainElectricSheepService(electricSheepRepository);
	}
}
