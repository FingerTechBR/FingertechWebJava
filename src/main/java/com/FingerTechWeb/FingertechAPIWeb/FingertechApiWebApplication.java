package com.FingerTechWeb.FingertechAPIWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FingertechApiWebApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(FingertechApiWebApplication.class);
        builder.headless(false).run(args);
	}

}
