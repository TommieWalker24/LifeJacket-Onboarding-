package com.juniorAssociate.RSI.lifeJacket;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Entities.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class LifeJacketApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LifeJacketApplication.class);
	}

	public static void main(String[] args) {
		Categories category = new Categories();
		category.setCategory(Category.CALENDAR.getType());
		System.out.println(category.getCategory());

		SpringApplication.run(LifeJacketApplication.class, args);
	}
}

