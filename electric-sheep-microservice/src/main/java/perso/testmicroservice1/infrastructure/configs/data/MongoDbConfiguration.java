package perso.testmicroservice1.infrastructure.configs.data;


import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import perso.testmicroservice1.infrastructure.data.repositories.orders.MongoReplicantRepository;

@EnableMongoRepositories(basePackageClasses = MongoReplicantRepository.class)
public class MongoDbConfiguration {
}
