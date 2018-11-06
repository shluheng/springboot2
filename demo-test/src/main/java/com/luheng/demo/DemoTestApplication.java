package com.luheng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * @SpringBootApplication = @EnableAutoConfiguration + @ComponentScan (扫所在包的类，或所在包下的子包类)
 * 
 * @author Administrator 
 *
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoTestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoTestApplication.class, args);
	}
}
