package com.cedge.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cedge.entity.ADB;

public interface ADBRepo extends JpaRepository<ADB, Integer> {
	
	public List<ADB> findByDate(LocalDate yesterday);

}
