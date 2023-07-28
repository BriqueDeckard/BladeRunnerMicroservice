package perso.petmicroservice.petmicroservice.infrastructure.configs.data;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import perso.petmicroservice.petmicroservice.infrastructure.data.repositories.MongoPetRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = MongoPetRepository.class)
public class MongoDbConfiguration extends AbstractMongoClientConfiguration {

	@Override
	protected String getDatabaseName() {
		return "blade-runner";
	}

	@Override
	public MongoClient mongoClient() {
		final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/blade-runner");
		final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.uuidRepresentation(UuidRepresentation.JAVA_LEGACY)
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}
}
