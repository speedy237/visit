package com.ecoleit.fap.visit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecoleit.fap.visit.dto.StandCellDTO;
import com.ecoleit.fap.visit.service.StandCellService;

@RestController
@RequestMapping("stand-cell")
public class StandCellController {
	private StandCellService service;

	public StandCellController(StandCellService service) {
		super();
		this.service = service;
	}
	@GetMapping("{id}")
	public StandCellDTO getCells(@PathVariable("id") int id) {
		
		return service.getCell(id);
		
	}

}
