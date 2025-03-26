package com.cedge.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.cedge.entity.ADB;

public interface DailyReportsService {
	
	public List<ADB> getListOfRecords(LocalDate yesterday);
	public Map<String,Long> getSucesscount(List<ADB> list);
	public Map<String,Long> getUnsucesscount(List<ADB> list);
	public boolean InsertIntoDailyReports(List<ADB> list,  Map<String, Long> sucess, Map<String, Long> unsucess, LocalDate date);

	

}
