package com.ecoleit.fap.visit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoleit.fap.visit.entity.Stand;
import com.ecoleit.fap.visit.entity.StandCell;

public interface StandCellReposoitory extends JpaRepository<StandCell, Integer>{
	public List<StandCell> findByStand(Stand stand);


}
