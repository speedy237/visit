package com.ecoleit.fap.visit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoleit.fap.visit.entity.Stand;
import com.ecoleit.fap.visit.repository.StandRepository;

@Service
public class StandService {
	
	private StandRepository repos;

	public StandService(StandRepository repos) {
		super();
		this.repos = repos;
	}
	
	public void addStand(Stand stand) {
		
		repos.save(stand);
		
	}
	
	public List<Stand> getStands(){
		return repos.findAll();
	}
	
	public Stand getStand(int id){
		return repos.findById(id).get();
	}
	
	
	
	

}
