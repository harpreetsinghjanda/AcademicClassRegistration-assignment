package com.my.AcademicClassRegistration.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckResource {

	@GetMapping("/healthcheck")
	public String healthCheck()	{
		return "Alive";
	}
}
