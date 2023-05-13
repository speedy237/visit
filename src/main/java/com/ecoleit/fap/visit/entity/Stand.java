package com.ecoleit.fap.visit.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="stand")
public class Stand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStand;
	@Column
	private String name;
	
	@OneToOne
	@JoinColumn(name="idExposant")
	private Exposant exposant;
	
	@OneToMany(mappedBy = "stand", cascade = CascadeType.ALL)
	private List<StandCell> standCell;
	
	@OneToMany(mappedBy="stand")
	private List<Visit> visit;

	public Stand() {
		super();
	}

	public Stand(String name, Exposant exposant, List<StandCell> standCell, List<Visit> visit) {
		super();
		this.name = name;
		this.exposant = exposant;
		this.standCell = standCell;
		this.visit = visit;
	}

	public Stand(int idStand, String name, Exposant exposant, List<StandCell> standCell, List<Visit> visit) {
		super();
		this.idStand = idStand;
		this.name = name;
		this.exposant = exposant;
		this.standCell = standCell;
		this.visit = visit;
	}

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

	public Exposant getExposant() {
		return exposant;
	}

	public void setExposant(Exposant exposant) {
		this.exposant = exposant;
	}

	public List<StandCell> getStandCell() {
		return standCell;
	}

	public void setStandCell(List<StandCell> standCell) {
		this.standCell = standCell;
	}

	public List<Visit> getVisit() {
		return visit;
	}

	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}
	
	

}
