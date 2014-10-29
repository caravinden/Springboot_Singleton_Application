package com.aravind.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Class from which all application class invoked
 * 
 * @author aravind
 * @date 29-09-2014
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
public class EmployeeApplication {

	/**
	 * Main function to run employee application
	 * 
	 * @param args
	 */

	public static void main(String args[]) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
