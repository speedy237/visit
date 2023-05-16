package com.ecoleit.fap.visit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoleit.fap.visit.dto.ExposantDTO;
import com.ecoleit.fap.visit.dto.StandDTO;
import com.ecoleit.fap.visit.entity.Exposant;
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
	
	public List<StandDTO> getStands(){
		List<Stand> list=repos.findAll();
		System.out.println("debut parcours liste");
		System.out.println("nbre: "+list.size());
		List<StandDTO> stands=new ArrayList<StandDTO>();
		for(Stand entity:list) {
			System.out.println("elements"+entity.getName());
			StandDTO stand=new StandDTO();
			stand.mapStandEntity(entity);
			stands.add(stand);
		}
		return stands;
		
	}
	
	public StandDTO getStand(int id){
		Stand entity=repos.findById(id).get();
		StandDTO stand=new StandDTO();
		stand.mapStandEntity(entity);
		return stand;
	}
	
	 
	
	 
	 
	
}
