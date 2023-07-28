package perso.library.domain.contracts.repositories;

import java.util.Collection;

public interface GenericDomainRepository<ENTITY, IDENTIFIER> {
	ENTITY create(ENTITY entity);

	Collection<ENTITY> read();

	ENTITY read(IDENTIFIER identifier);

	ENTITY update(ENTITY entity, IDENTIFIER identifier);

	void delete(IDENTIFIER identifier);

	void delete();
}
