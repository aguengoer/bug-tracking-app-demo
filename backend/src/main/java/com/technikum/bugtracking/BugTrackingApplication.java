package com.technikum.bugtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.web.client.HttpClientMetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = HttpClientMetricsAutoConfiguration.class)
@ConfigurationPropertiesScan
public class BugTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackingApplication.class, args);
	}

}
