package com.ecoleit.fap.visit.controller;
import java.io.IOException;
import java.util.List;
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
import com.ecoleit.fap.visit.dto.StandCellDTO;
import com.ecoleit.fap.visit.dto.StandDTO;
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
	@ResponseStatus(HttpStatus.CREATED)
	public void addStandCell(@PathVariable("id") int id, @RequestBody StandCellDTO cellDTO) {
		StandDTO standDTO=service2.getStand(id);
		System.out.println("idStand: "+standDTO.getIdStand()+", name: "+standDTO.getName());
		cellDTO.setStand(standDTO);
		StandCell cell=new StandCell();
		cell.mapStandCellDTO(cellDTO);
		System.out.println("typologie: "+cellDTO.getTypology()+", url: "+cellDTO.getUrl()+", idStand "+cellDTO.getStand().getIdStand());
		service1.addStandCell(cell);

	 
		
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public StandDTO getStand(@PathVariable("id") int id) {
		return service2.getStand(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<StandDTO> getStands(){
		
		return service2.getStands();
		
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("{id}/stand-cell")
	public List<StandCellDTO> getCellByStands(@PathVariable("id") int id){
		System.out.println("debut ok");
		
		StandDTO stand=service2.getStand(id);
		System.out.println("Stand: "+stand.getName());

		return service1.getCellByStand(stand);
	}

}
