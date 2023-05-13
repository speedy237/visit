package com.ecoleit.fap.visit.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecoleit.fap.visit.entity.Stand;
import com.ecoleit.fap.visit.entity.StandCell;
import com.ecoleit.fap.visit.service.StandCellService;
import com.ecoleit.fap.visit.service.StandService;

@RestController
@RequestMapping("/stand")
public class StandController {
	
	private StandCellService service1;
	private StandService service2;
	public StandController(StandCellService service1, StandService service2) {
		super();
		this.service1 = service1;
		this.service2 = service2;
	}
	
	@PostMapping("{id}/stand-cell")
	public ResponseEntity<String> addStandCell(@PathVariable("id") int id, @RequestParam("file") MultipartFile file, @RequestBody StandCell cell) {
		Stand stand=service2.getStand(id);
		cell.setStand(stand);
		service1.addStandCell(cell);
		try {
			cell.setContenu(file.getBytes());
			return ResponseEntity.ok("cell succefull add");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Stand getStand(@PathVariable("id") int id) {
		return service2.getStand(id);
	}

}
