package perso.replicantmicroservice.application.dto.requests;

import javax.validation.constraints.NotNull;

public class UpdateReplicantAgeRequestDTO {
	@NotNull
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UpdateReplicantAgeRequestDTO{" +
				"age=" + age +
				'}';
	}
}
