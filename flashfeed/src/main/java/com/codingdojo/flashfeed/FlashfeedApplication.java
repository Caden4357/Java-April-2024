package com.codingdojo.flashfeed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.codingdojo.flashfeed.services.UploadService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FlashfeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashfeedApplication.class, args);
	}
	// Declares a bean in the Spring application context
	@Bean
	// Defines a bean of type CommandLineRunner that will be executed after the Spring application context is initialized
	CommandLineRunner init(UploadService storageService) {
	    // Returns a lambda expression that implements the run method of the CommandLineRunner interface
	    return (args) -> {
	        // Calls the init method of the UploadService to initialize the storage directory
	        storageService.init();
	    };
	}
}
