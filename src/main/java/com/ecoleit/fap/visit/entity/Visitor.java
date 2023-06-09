package com.ecoleit.fap.visit.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="visitor")
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisitor;
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
	
	@Enumerated(EnumType.STRING)
	private TypeVisitor typeVisitor;
	
	@OneToMany(mappedBy="visitor")
	private List<Visit> visit=new ArrayList<Visit>();

	public Visitor() {
		super();
	}

	

	public Visitor(String name, String surname, String adresse, String phone, String email, String password,
			String poBox, String town, TypeVisitor typeVisitor) {
		super();
		this.name = name;
		this.surname = surname;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.poBox = poBox;
		this.town = town;
		this.typeVisitor = typeVisitor;
	}
	
	



	public int getIdVisitor() {
		return idVisitor;
	}

	public void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public TypeVisitor getTypeVisitor() {
		return typeVisitor;
	}

	public void setTypeVisitor(TypeVisitor typeVisitor) {
		this.typeVisitor = typeVisitor;
	}

	public List<Visit> getVisit() {
		return visit;
	}

	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}



	public String getTown() {
		return town;
	}



	public void setTown(String town) {
		this.town = town;
	}
	
	

}
