package perso.petmicroservice.petmicroservice.application.controller;

import java.util.Set;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/v1/pet")
public class PetController {


	@GetMapping()
	String all() {
		return "OK";
	}


	@ExceptionHandler({ IllegalArgumentException.class })
	public void handleIllegalArgumentException(){

	}
}
