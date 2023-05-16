package com.ecoleit.fap.visit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecoleit.fap.visit.entity.Exposant;
import com.ecoleit.fap.visit.dto.*;
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
	public void addExposant(@RequestBody ExposantDTO exposant) {
		Exposant entity=new Exposant();
		entity.mapExposantDTO(exposant);
		service1.addExposant(entity);
	}
	
	@PostMapping("{id}/stand")
	@ResponseStatus(HttpStatus.CREATED)
	public void addStand(@PathVariable("id") int id , @RequestBody StandDTO standDto) {
		
		ExposantDTO exposantDTO=service1.getExposant(id);
		standDto.setExposant(exposantDTO);
		Stand stand=new Stand();
		stand.mapStandDTO(standDto);
		stand.mapStandDTO(standDto);
	 
		service2.addStand(stand);	
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ExposantDTO> getExposants(){
		
		return this.service1.getAllExposants();
		
	}
	@GetMapping("{id}")
	public ExposantDTO getExposant(@PathVariable("id")int id) {
		return this.service1.getExposant(id);
	}
}
