package com.ecoleit.fap.visit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoleit.fap.visit.dto.StandCellDTO;
import com.ecoleit.fap.visit.dto.StandDTO;
import com.ecoleit.fap.visit.entity.Stand;
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
	
	public StandCellDTO getCell(int id ) {
		StandCell entity=repos.findById(id).get();
		StandCellDTO standCellDTO=new StandCellDTO();
		standCellDTO.mapStandCellEntity(entity);
		return standCellDTO;
	}
	
	public List<StandCellDTO> getCellByStand(StandDTO standDTO){
		
		System.out.println("recherche de tous les cells");
		Stand stand=new Stand();
		
		stand.mapStandDTO(standDTO);
		
		System.out.println("entity: "+stand.getName());
		System.out.println("voici liste");
		if(stand!=null) {
			
			List<StandCell> list=repos.findByStand(stand);
			System.out.println("fin liste");
			
			List<StandCellDTO> cells=new ArrayList<StandCellDTO>();
			System.out.println("parcours de la liste");
			for(StandCell entity:list) {
				StandCellDTO cell=new StandCellDTO();
				cell.mapStandCellEntity(entity);
				 
				cells.add(cell);
				System.out.println("it : "+cell.getIdCell());
			}
			
			return cells;
			
		}
		
		return new ArrayList<>();
		
		
		
		
	}
	
	 

}
