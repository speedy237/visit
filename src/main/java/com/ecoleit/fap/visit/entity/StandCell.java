package com.ecoleit.fap.visit.entity;
import com.ecoleit.fap.visit.dto.StandCellDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="standCell")
public class StandCell {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCell;
	@Enumerated(EnumType.STRING)
	private Typology typology;
	@Column
	private String url;
	
	@ManyToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="idStand",nullable=false)
	private Stand stand;

	public StandCell() {
		super();
	}

	public StandCell(int idCell, Typology typology, String url, Stand stand) {
		super();
		this.idCell = idCell;
		this.typology = typology;
		this.url = url;
		this.stand = stand;
	}

	public StandCell(Typology typology, String url) {
		super();
		this.typology = typology;
		this.url = url;
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

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}
	
	public void mapStandCellDTO(StandCellDTO standCellDTO) {
		this.setIdCell(standCellDTO.getIdCell());
		this.setTypology(standCellDTO.getTypology());
		this.setUrl(standCellDTO.getUrl());
		Stand stand=new Stand();
		stand.mapStandDTO(standCellDTO.getStand());
	}
}
