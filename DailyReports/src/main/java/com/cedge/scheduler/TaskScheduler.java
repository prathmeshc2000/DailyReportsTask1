package com.cedge.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.cedge.controller.ReportsController;

public class TaskScheduler {
	
	@Autowired
	private ReportsController reportsController;
	
	
	@Scheduled(cron = "0 0 20 * * ?")  // Every day at 8 PM
    public void scheduleTask() {
		reportsController.addDailyreports();
    }

}
