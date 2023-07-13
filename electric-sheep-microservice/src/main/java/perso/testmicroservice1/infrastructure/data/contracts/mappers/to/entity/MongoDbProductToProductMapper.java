package perso.testmicroservice1.infrastructure.data.contracts.mappers.to.entity;

import org.mapstruct.Mapper;
import perso.testmicroservice1.domain.model.ElectricSheep;
import perso.testmicroservice1.infrastructure.data.model.MongoDbElectricSheep;

@Mapper
public interface MongoDbProductToProductMapper {
	ElectricSheep toProduct(MongoDbElectricSheep mongoDbProduct);
}
