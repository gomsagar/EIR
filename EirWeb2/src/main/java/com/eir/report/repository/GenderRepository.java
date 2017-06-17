package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer> {


}
