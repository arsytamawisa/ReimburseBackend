package com.enigma.reimbursment.online;

import com.enigma.reimbursment.online.services.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
//public class OnlineApplication implements CommandLineRunner {
public class OnlineApplication {

//	@Resource
//	FilesStorageService storageService;

	@Bean
	public RestTemplate getResultTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
////		storageService.deleteAll();
//		storageService.init();
//	}
}
