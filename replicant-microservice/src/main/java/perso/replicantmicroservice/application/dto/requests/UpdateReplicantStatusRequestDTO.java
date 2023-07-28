package perso.replicantmicroservice.application.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import perso.replicantmicroservice.domain.enums.ReplicantStatus;

public class UpdateReplicantStatusRequestDTO {

	@NotNull
	@JsonProperty("status")
	private ReplicantStatus status;

	@JsonCreator
	public UpdateReplicantStatusRequestDTO(ReplicantStatus status) {
		this.status = status;
	}

	@JsonCreator
	public UpdateReplicantStatusRequestDTO() {
	}

	public ReplicantStatus getStatus() {
		return status;
	}

	public void setStatus(ReplicantStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UpdateReplicantRequest{" +
				"name='" + status + '\'' +
				'}';
	}
}
