package com.sundar.demo.mongochangestreams;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@Slf4j
public class MongochangestreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongochangestreamsApplication.class, args);
		log.info("Started mongochagestream demo applications...");

	}
}
