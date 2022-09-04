package com.spring.cassandra.api;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringReactiveCassandraApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(SpringReactiveCassandraApplication.class)
				.web(WebApplicationType.REACTIVE)
				.run(args);;
	}
}
