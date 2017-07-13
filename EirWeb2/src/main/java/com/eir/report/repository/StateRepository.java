package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	
	public State findBystateId(Integer stateId);
	
	public List<State> findAllByOrderByStateDescriptionAsc();
	

}
