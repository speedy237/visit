package com.ecoleit.fap.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoleit.fap.visit.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer>{

}
