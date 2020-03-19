package com.juniorAssociate.RSI.lifeJacket;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class LifeJacketApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LifeJacketApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LifeJacketApplication.class, args);
	}
}

