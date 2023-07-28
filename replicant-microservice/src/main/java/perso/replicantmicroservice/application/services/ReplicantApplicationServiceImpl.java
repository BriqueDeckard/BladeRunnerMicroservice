package perso.replicantmicroservice.application.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.application.contracts.ReplicantApplicationService;

@Service
public class ReplicantApplicationServiceImpl implements ReplicantApplicationService {
	@Override
	public UUID getAndCheckUuid(String id) {
		UUID uuid;
		try {
			uuid = UUID.fromString(id);
		} catch (Exception e) {
			throw e;
		}
		return uuid;
	}
}
