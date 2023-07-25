package perso.library.domain.contracts.repositories;

import java.util.Set;

public interface GenericDomainRepository<ENTITY,IDENTIFIER> {
	ENTITY save(ENTITY entity);
	void deleteAll();
	Set<ENTITY> findAll();
	ENTITY findByIdentifier(IDENTIFIER identifier);

	void deleteByIdentifier(String identifier);
}
