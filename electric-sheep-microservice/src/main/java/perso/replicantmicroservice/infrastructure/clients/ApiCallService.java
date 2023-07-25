package perso.replicantmicroservice.infrastructure.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiCallService {
	private final WebClient webClient;

	public ApiCallService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://0.0.0.0:668").build();
	}

	public Mono<String> someRestCall(String route){
		return this.webClient.get().uri(route).retrieve().bodyToMono(String.class);
	}
}
