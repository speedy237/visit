package com.ecoleit.fap.visit.dto;

import com.ecoleit.fap.visit.entity.StandCell;
import com.ecoleit.fap.visit.entity.Typology;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class StandCellDTO {
	
	private int idCell;
	
	private Typology typology;
	
	private String url;
	
	private StandDTO stand;

	public StandCellDTO(Typology typology, String url) {
		super();
		this.typology = typology;
		this.url = url;
	}

	public StandCellDTO(int idCell, Typology typology, String url, StandDTO stand) {
		super();
		this.idCell = idCell;
		this.typology = typology;
		this.url = url;
		this.stand = stand;
	}

	public StandCellDTO() {
		super();
	}

	public int getIdCell() {
		return idCell;
	}

	public void setIdCell(int idCell) {
		this.idCell = idCell;
	}

	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public StandDTO getStand() {
		return stand;
	}

	public void setStand(StandDTO stand) {
		this.stand = stand;
	}
	public void mapStandCellEntity(StandCell entity) {
		this.setIdCell(entity.getIdCell());
		this.setUrl(entity.getUrl());
		this.setTypology(entity.getTypology());
		StandDTO stand=new StandDTO();
		stand.mapStandEntity(entity.getStand());
		this.setStand(stand);
	}
	

}
