package com.test.app.job;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@ComponentScan
@EnableScheduling
public class SpringJobSchedule {

	private static final Logger LOGGER = LogManager.getLogger(SpringJobSchedule.class);
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void run() {
		LOGGER.info("Current time is :: " + Calendar.getInstance().getTime());
	}
}
