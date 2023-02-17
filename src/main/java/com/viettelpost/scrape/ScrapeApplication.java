package com.viettelpost.scrape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ScrapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrapeApplication.class, args);
	}

}
