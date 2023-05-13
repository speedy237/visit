package com.ecoleit.fap.visit.service;

import org.springframework.stereotype.Service;

import com.ecoleit.fap.visit.entity.StandCell;
import com.ecoleit.fap.visit.repository.StandCellReposoitory;

@Service
public class StandCellService {
	
	public StandCellReposoitory repos;

	public StandCellService(StandCellReposoitory repos) {
		super();
		this.repos = repos;
	}
	
	public void addStandCell(StandCell stand) {
		
		repos.save(stand);
		
	}
	
	public StandCell getCell(int id ) {
		return repos.findById(id).get();
	}

}
