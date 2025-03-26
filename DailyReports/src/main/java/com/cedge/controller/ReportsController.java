package com.cedge.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cedge.entity.ADB;
import com.cedge.service.DailyReportsService;

@Controller
public class ReportsController {

	@Autowired
	private DailyReportsService reportService;

	public void addDailyreports() {
		LocalDate yesterday = LocalDate.now().minusDays(2);
		System.out.println(yesterday);

		List<ADB> listOfRecords = reportService.getListOfRecords(yesterday);
		Map<String, Long> sucessMap = reportService.getSucesscount(listOfRecords);
//		System.out.println("sucess : "+ sucesscount);

		Map<String, Long> unsucessMap = reportService.getUnsucesscount(listOfRecords);
//		System.out.println("unsucess : "+ unsucesscount);
		
		

		boolean insertIntoDailyReports = reportService.InsertIntoDailyReports(listOfRecords, sucessMap, unsucessMap,yesterday);

		if (insertIntoDailyReports) {
			System.out.println("Records Updates Sucessfully");
		}else {
			System.out.println("Internal Server error");
		}
		
	}

}
