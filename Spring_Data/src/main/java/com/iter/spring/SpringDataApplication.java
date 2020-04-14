package com.iter.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.iter.spring.rest.repository")
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
