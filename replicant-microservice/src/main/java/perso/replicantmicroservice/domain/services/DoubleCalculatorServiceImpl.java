package perso.replicantmicroservice.domain.services;

import org.springframework.stereotype.Service;
import perso.replicantmicroservice.domain.contracts.services.CalculatorService;

/**
 * A Spring service that provides arithmetic operations on Double numbers.
 * Implements the CalculatorService<Double> interface.
 */
@Service
public class DoubleCalculatorServiceImpl implements CalculatorService<Double> {
	/**
	 * Adds two Double numbers.
	 *
	 * @param a The first Double operand.
	 * @param b The second Double operand.
	 * @return The result of adding a and b.
	 */
	@Override
	public Double add(Double a, Double b) {
		return a + b;
	}
	/**
	 * Subtracts one Double number from another.
	 *
	 * @param a The Double value to subtract from.
	 * @param b The Double value to subtract.
	 * @return The result of subtracting b from a.
	 */
	@Override
	public Double subtract(Double a, Double b) {
		return a - b;
	}
	/**
	 * Multiplies two Double numbers.
	 *
	 * @param a The first Double operand.
	 * @param b The second Double operand.
	 * @return The result of multiplying a and b.
	 */
	@Override
	public Double multiply(Double a, Double b) {
		return a * b;
	}
	/**
	 * Divides one Double number by another.
	 *
	 * @param a The Double value to be divided.
	 * @param b The Double value to divide by.
	 * @return The result of dividing a by b, or Double.POSITIVE_INFINITY if b is 0.
	 */
	@Override
	public Double divide(Double a, Double b) {
		if (b == 0) {
			return Double.POSITIVE_INFINITY;
		}
		return a / b;
	}
}
