package perso.testmicroservice1.domain.contracts.electricsheep;

import java.math.BigDecimal;
import java.util.UUID;

public interface ElectricSheepContract {
	String getName();

	BigDecimal getPrice();

	UUID getId();
}
