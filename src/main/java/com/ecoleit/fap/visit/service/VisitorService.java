package com.ecoleit.fap.visit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoleit.fap.visit.entity.Visitor;
import com.ecoleit.fap.visit.repository.VisitorRepository;

@Service
public class VisitorService {
	private VisitorRepository repos;

	public VisitorService(VisitorRepository repos) {
		 
		this.repos = repos;
	}
	
	public Visitor addVisitor(Visitor visitor) {
		return repos.save(visitor);
	}
	
	public Visitor getVisitor(int id) {
		return repos.findById(id).get();
	}
	
	public List<Visitor> getAllVisitor(){
		
		return repos.findAll();
		
	}

}
