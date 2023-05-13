package com.ecoleit.fap.visit.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Lob
	@Column
	private byte[] contenu;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional=false)
	private Stand stand;

	public StandCell() {
		super();
	}

	public StandCell(int idCell, Typology typology, byte[] contenu, Stand stand) {
		super();
		this.idCell = idCell;
		this.typology = typology;
		this.contenu = contenu;
		this.stand = stand;
	}

	public StandCell(Typology typology, byte[] contenu) {
		super();
		this.typology = typology;
		this.contenu = contenu;
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

	public byte[] getContenu() {
		return contenu;
	}

	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}
	
	

	
	
}
