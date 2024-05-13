package com.TrueArchery.Archery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.TrueArchery.Archery"})

public class ArcheryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArcheryApplication.class, args);
	}

}
