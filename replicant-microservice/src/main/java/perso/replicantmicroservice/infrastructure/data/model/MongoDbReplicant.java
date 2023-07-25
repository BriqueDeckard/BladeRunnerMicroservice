package perso.replicantmicroservice.infrastructure.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import perso.replicantmicroservice.domain.contracts.model.ReplicantContract;
import perso.replicantmicroservice.domain.enums.ReplicantStatus;

@Document("replicant")
public class MongoDbReplicant implements ReplicantContract<String> {

	@Id
	private String identifier;
	private String name;
	private Integer age;
	private ReplicantStatus status;

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
	public ReplicantStatus getStatus() {
		return status;
	}

	public void setIdentifier(String identifier) {
		if(this.identifier != null){
			throw new UnsupportedOperationException("ID is already defined");
		}
		this.identifier = identifier;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setStatus(ReplicantStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MongoDbReplicant{" +
				"identifier=" + identifier +
				", name='" + name + '\'' +
				", age=" + age +
				", status=" + status +
				'}';
	}
}
