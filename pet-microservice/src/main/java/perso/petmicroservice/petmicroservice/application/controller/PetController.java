package perso.petmicroservice.petmicroservice.application.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perso.petmicroservice.petmicroservice.domain.contracts.services.PetDomainService;
import perso.petmicroservice.petmicroservice.domain.model.Pet;


@RestController()
@RequestMapping("/api/v1/pet")
public class PetController {

	private final PetDomainService petDomainService;

	@Autowired
	public PetController(PetDomainService petDomainService) {
		this.petDomainService = petDomainService;
	}

	@GetMapping()
	Set<Pet> all() {
		return petDomainService.findAll();
	}


	@ExceptionHandler({ IllegalArgumentException.class })
	public void handleIllegalArgumentException(){

	}
}
