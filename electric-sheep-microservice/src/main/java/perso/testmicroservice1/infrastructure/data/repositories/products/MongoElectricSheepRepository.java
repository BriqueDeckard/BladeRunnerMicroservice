package perso.testmicroservice1.infrastructure.data.repositories.products;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import perso.testmicroservice1.domain.contracts.electricsheep.ElectricSheepRepository;
import perso.testmicroservice1.domain.model.ElectricSheep;
import perso.testmicroservice1.infrastructure.data.contracts.mappers.to.db.ProductToMongoDbProductMapper;
import perso.testmicroservice1.infrastructure.data.contracts.mappers.to.entity.MongoDbProductToProductMapper;
import perso.testmicroservice1.infrastructure.data.model.MongoDbElectricSheep;

@Component
@Primary
public class MongoElectricSheepRepository implements ElectricSheepRepository {
	@Autowired
	private ProductToMongoDbProductMapper productToMongoDbProductMapper;

	@Autowired
	private MongoDbProductToProductMapper mongoDbProductToProductMapper;

	private final SpringDataMongoProductRepository productRepository;

	@Autowired
	public MongoElectricSheepRepository(SpringDataMongoProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ElectricSheep findById(UUID id) {
		Optional<MongoDbElectricSheep> oProduct = productRepository.findById(id);
		MongoDbElectricSheep product = oProduct.orElseThrow();
		return mongoDbProductToProductMapper.toProduct(product);
	}

	@Override
	public void save(ElectricSheep electricSheep) {
		MongoDbElectricSheep mongoDbProduct = productToMongoDbProductMapper.toMongoDb(electricSheep);
		productRepository.save(mongoDbProduct);
	}

	@Override
	public void delete(UUID id) {
		productRepository.delete(id);
	}
}
