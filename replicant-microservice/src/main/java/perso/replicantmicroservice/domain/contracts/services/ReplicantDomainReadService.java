package perso.replicantmicroservice.domain.contracts.services;

import java.util.Set;
import org.springframework.stereotype.Service;
import perso.replicantmicroservice.domain.model.Replicant;

@Service
public interface ReplicantDomainReadService {
	Set<Replicant> findAll();

	Replicant findByIdentifier(String identifier);
}
