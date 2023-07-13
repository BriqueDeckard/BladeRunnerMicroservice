package perso.testmicroservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Used to bootstrap and launch the Spring application from a Java main method.
 *
 * @author Deqard
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = { "perso.*" })
public class TestMicroservice1Application {

	/**
	 * Entry point of the application
	 *
	 * @param args arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(TestMicroservice1Application.class, args);
	}

}
