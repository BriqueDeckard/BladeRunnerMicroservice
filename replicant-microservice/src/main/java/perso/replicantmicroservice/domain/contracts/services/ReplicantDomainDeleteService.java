package perso.replicantmicroservice.domain.contracts.services;

import org.springframework.stereotype.Service;

@Service
public interface ReplicantDomainDeleteService {
	void deleteAll();

	void deleteByIdentifier(String identifier);
}
