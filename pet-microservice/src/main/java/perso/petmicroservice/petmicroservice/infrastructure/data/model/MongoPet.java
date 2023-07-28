package perso.petmicroservice.petmicroservice.infrastructure.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import perso.petmicroservice.petmicroservice.domain.contracts.model.PetContract;
import perso.petmicroservice.petmicroservice.domain.enums.PetStatus;

@Document("pets")
public class MongoPet implements PetContract<String> {

	@Id
	private String identifier;
	private String name;
	private Integer age;
	private PetStatus status;

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setStatus(PetStatus status) {
		this.status = status;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public PetStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "MongoPet{" +
				"identifier='" + identifier + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", status=" + status +
				'}';
	}
}
