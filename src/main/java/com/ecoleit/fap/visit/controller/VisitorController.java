package com.ecoleit.fap.visit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecoleit.fap.visit.entity.Visitor;
import com.ecoleit.fap.visit.service.VisitorService;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
	private VisitorService service;
	
	
	
	public VisitorController(VisitorService service) {
		super();
		this.service = service;
	}



	@PostMapping
	public void addVisitor(@RequestBody Visitor visitor) {
		 service.addVisitor(visitor);
	}
	@GetMapping
	public List<Visitor> getVisitors(){
		
		return service.getAllVisitor();
		
	}

}
