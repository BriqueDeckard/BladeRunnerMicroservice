package perso.replicantmicroservice.domain.model;

import java.util.UUID;
import perso.replicantmicroservice.domain.contracts.model.ReplicantContract;
import perso.replicantmicroservice.domain.enums.ReplicantStatus;

public class Replicant implements ReplicantContract<UUID> {
	private UUID identifier;
	private String name;
	private Integer age;
	private ReplicantStatus status;

	public Replicant(String name) {
		this.name = name;
		this.age = 0;
		this.status = ReplicantStatus.CREATED;
	}

	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}

	@Override
	public UUID getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return name;
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
	public Integer getAge() {
		return age;
	}

	@Override
	public ReplicantStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Replicant{" +
				"identifier=" + identifier +
				", name='" + name + '\'' +
				", age=" + age +
				", status=" + status +
				'}';
	}
}
