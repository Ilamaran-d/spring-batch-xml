package com.pvinsoft.batch;

import org.apache.log4j.BasicConfigurator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		BasicConfigurator.configure();

		
		String[] springConfig  = {"config/jobs/jobConfig.xml"};
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job jobCsvTodb = (Job) context.getBean("csvTodbJob");
        try {
            JobExecution executionCsvTodb= jobLauncher.run(jobCsvTodb, new JobParameters());
            System.out.println("Exit Status Job 1:: " + executionCsvTodb.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			if(context != null)
				context.close();
		}
        System.out.println("Done");

	}

}
