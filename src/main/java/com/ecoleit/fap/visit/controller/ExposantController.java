package com.ecoleit.fap.visit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecoleit.fap.visit.entity.Exposant;
import com.ecoleit.fap.visit.entity.Stand;
import com.ecoleit.fap.visit.service.ExposantService;
import com.ecoleit.fap.visit.service.StandService;

@RestController
@RequestMapping("exposants")
public class ExposantController {
	
	private ExposantService service1;
	private StandService service2;
	
	
	
	public ExposantController(ExposantService service1, StandService service2) {
		super();
		this.service1 = service1;
		this.service2 = service2;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addExposant(@RequestBody Exposant exposant) {
		service1.addExposant(exposant);
	}
	
	@PostMapping("{id}/stand")
	@ResponseStatus(HttpStatus.CREATED)
	public void addStand(@PathVariable("id") int id , @RequestBody Stand stand) {
		
		Exposant exposant=service1.getExposant(id);
		stand.setExposant(exposant);
		service2.addStand(stand);
		
	}
	

}
