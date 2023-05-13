package com.ecoleit.fap.visit.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public Exposant getExposant(int id) {
		return repos.findById(id).get();
	}
	
	 
	
	public List<Exposant> getAllExposants(){
		
		return repos.findAll();
		
	}
}