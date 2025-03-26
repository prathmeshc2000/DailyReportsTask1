package com.cedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cedge.controller.ReportsController;

@SpringBootApplication
//@EnableScheduling
public class DailyReportsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DailyReportsApplication.class, args);
		
		ReportsController bean = run.getBean(ReportsController.class);
		bean.addDailyreports();
	}

}
