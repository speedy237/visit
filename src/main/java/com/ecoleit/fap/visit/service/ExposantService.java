package com.ecoleit.fap.visit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoleit.fap.visit.dto.ExposantDTO;
import com.ecoleit.fap.visit.entity.Exposant;
import com.ecoleit.fap.visit.entity.Stand;
import com.ecoleit.fap.visit.entity.Visitor;
import com.ecoleit.fap.visit.repository.ExposantRepository;

@Service
public class ExposantService {
	private ExposantRepository repos;

	public ExposantService(ExposantRepository repos) {
		super();
		this.repos = repos;
	}
	
	public void addExposant(Exposant exp) {
		repos.save(exp);
	}
	
	public ExposantDTO getExposant(int id) {
		
		Exposant entity= repos.findById(id).get();
		ExposantDTO exposant=new ExposantDTO();
		exposant.mapExposantEntity(entity);
		return exposant;
	}
	
	 
	
	public List<ExposantDTO> getAllExposants(){
		List<ExposantDTO> exposants=new ArrayList<ExposantDTO>();
		List<Exposant> list=repos.findAll();
		for(Exposant entity:list) {
			ExposantDTO exposant=new ExposantDTO();
			exposant.mapExposantEntity(entity);
			exposants.add(exposant);
			
		}
		 
		 return exposants;
		
	}
}