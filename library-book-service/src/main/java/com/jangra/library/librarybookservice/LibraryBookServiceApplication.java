package com.jangra.library.librarybookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBookServiceApplication.class, args);
	}

}
