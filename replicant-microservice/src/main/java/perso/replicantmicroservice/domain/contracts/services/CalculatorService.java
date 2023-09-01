package perso.replicantmicroservice.domain.contracts.services;

import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorService<T extends Number> {

	/**
	 * Adds two numbers.
	 *
	 * @param a The first number.
	 * @param b The second number.
	 * @return The sum of a and b.
	 */
	T add(@NotNull T a, @NotNull T b);

	/**
	 * Subtracts one number from another.
	 *
	 * @param a The first number.
	 * @param b The number to subtract from a.
	 * @return The result of subtracting b from a.
	 */
	T subtract(@NotNull T a, @NotNull T b);

	/**
	 * Multiplies two numbers.
	 *
	 * @param a The first number.
	 * @param b The second number.
	 * @return The product of a and b.
	 */
	T multiply(@NotNull T a, @NotNull T b);

	/**
	 * Divides one number by another.
	 *
	 * @param a The dividend.
	 * @param b The divisor.
	 * @return The result of dividing a by b.
	 * @throws ArithmeticException If b is zero.
	 */
	T divide(@NotNull T a, @NotNull T b) throws ArithmeticException;
}
