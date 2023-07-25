package perso.replicantmicroservice.infrastructure.clients;

import java.net.ConnectException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import perso.replicantmicroservice.application.dto.response.PetDto;
import reactor.core.publisher.Flux;

@Service
public class ApiCallService {
	private final WebClient webClient;

	public ApiCallService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://0.0.0.0:668/blade-runner").build();
	}

	public Flux<PetDto> someRestCall(String route) {
		Flux<PetDto> response;
		try {
			response = this.webClient.get().uri(route).retrieve().bodyToFlux(PetDto.class);
		} catch (Exception ce) {
			throw new IllegalStateException("Not available", ce);
		}
		return response;
	}
}
