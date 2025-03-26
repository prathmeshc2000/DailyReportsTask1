package com.cedge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cedge.entity.DailyReports;

public interface DailyReportsRepo extends JpaRepository<DailyReports, Integer>{

}
