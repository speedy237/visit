package com.ecoleit.fap.visit.dto;

import java.util.ArrayList;
import java.util.List;

import com.ecoleit.fap.visit.entity.Exposant;
import com.ecoleit.fap.visit.entity.Stand;
import com.fasterxml.jackson.annotation.JsonProperty;

 
public class StandDTO {
	
	
	private int idStand;
	
	private String name;
	
	private ExposantDTO exposant;

	private List <StandCellDTO>  cells;
     
	public int getIdStand() {
		return idStand;
	}

	public void setIdStand(int idStand) {
		this.idStand = idStand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExposantDTO getExposant() {
		return exposant;
	}

	public void setExposant(ExposantDTO exposant) {
		this.exposant = exposant;
	}

	public StandDTO(int idStand, String name,List <StandCellDTO>  cells) {
		super();
		this.idStand = idStand;
		this.name = name;
		this.cells=cells;
	}

	public StandDTO(String name) {
		super();
		this.name = name;
	}

	public StandDTO() {
		super();
		this.cells=new ArrayList<StandCellDTO>();
	}

	public List<StandCellDTO> getCells() {
		return cells;
	}

	public void setCells(List<StandCellDTO> cells) {
		this.cells = cells;
	}
	
	public void mapStandEntity(Stand entity) {
		
		this.setName(entity.getName());
		this.setIdStand(entity.getIdStand());
		ExposantDTO exposant=new ExposantDTO();
		exposant.mapExposantEntity(entity.getExposant());
		this.setExposant(exposant);
		
	}
	
	
	
	
	
	

}
