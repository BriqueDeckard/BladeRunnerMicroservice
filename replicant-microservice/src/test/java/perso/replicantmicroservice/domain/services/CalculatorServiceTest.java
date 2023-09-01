package perso.replicantmicroservice.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perso.replicantmicroservice.domain.contracts.services.CalculatorService;

/**
 * This class contains unit tests for the {@link CalculatorService} implementation.
 * It tests various mathematical operations provided by the calculator service.
 */
@SpringBootTest
@DisplayName("Calculator Service Test")
class CalculatorServiceTest {

	private final CalculatorService<Double> calculatorService;

	@Autowired
	public CalculatorServiceTest(CalculatorService<Double> calculatorService) {
		this.calculatorService = calculatorService;
	}

	/**
	 * Tests the addition operation with positive numbers.
	 */
	@ParameterizedTest
	@CsvSource({
			"1, 2, 3",
			"-3, 5, 2",
			"10, 20, 30"
	})
	@DisplayName("Test addition with positive numbers")
	void testAdditionWithPositiveNumbers(Double a, Double b, Double expected) {
		// Given
		// No additional setup required

		// When
		Double result = calculatorService.add(a, b);

		// Then
		assertEquals(expected, result);
	}

	/**
	 * Tests the subtraction operation with positive numbers.
	 */
	@ParameterizedTest
	@CsvSource({
			"2, 1, 1",
			"3, 2, 1",
			"66, 33, 33"
	})
	@DisplayName("Test subtraction with positive numbers")
	void testSubtractionWithPositiveNumbers(Double a, Double b, Double expected) {
		// Given
		// No additional setup required

		// When
		Double result = calculatorService.subtract(a, b);

		// Then
		assertEquals(expected, result);
	}

	/**
	 * Tests the multiplication operation with positive numbers.
	 */
	@ParameterizedTest
	@CsvSource({
			"2, 1, 2",
			"3, 2, 6",
			"66, 33, 2178"
	})
	@DisplayName("Test multiplication with positive numbers")
	void testMultiplicationWithPositiveNumbers(Double a, Double b, Double expected) {
		// Given
		// No additional setup required

		// When
		Double result = calculatorService.multiply(a, b);

		// Then
		assertEquals(expected, result);
	}

	/**
	 * Tests the division operation with positive numbers.
	 */
	@ParameterizedTest
	@CsvSource({
			"2, 1, 2",
			"3, 2, 1.5",
			"66, 33, 2",
			"1, 0, Infinity"
	})
	@DisplayName("Test division with positive numbers")
	void testDivisionWithPositiveNumbers(Double a, Double b, Double expected) {
		// Given
		// No additional setup required

		// When
		Double result = calculatorService.divide(a, b);

		// Then
		assertEquals(expected, result);
	}
}