package com.ecoleit.fap.visit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="exposant")
public class Exposant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExposant;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String adresse;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String password;
	@Column 
	private String poBox;
	@Column
	private String town;
	
	@OneToOne(mappedBy="exposant", cascade = CascadeType.ALL)
	private Stand stand;

	public Exposant() {
		super();
		this.stand=new Stand();
	}

	public Exposant(String name, String surname, String adresse, String phone, String email, String password,
			String poBox, String town) {
		super();
		this.name = name;
		this.surname = surname;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.poBox = poBox;
		this.town = town;
		this.stand=new Stand();
	}


	public Exposant(int idExposant, String name, String surname, String adresse, String phone, String email,
			String password, String poBox, String town, Stand stand) {
		super();
		this.idExposant = idExposant;
		this.name = name;
		this.surname = surname;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.poBox = poBox;
		this.town = town;
		this.stand = stand;
	}

	public int getIdExposant() {
		return idExposant;
	}

	public void setIdExposant(int idExposant) {
		this.idExposant = idExposant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	

}
