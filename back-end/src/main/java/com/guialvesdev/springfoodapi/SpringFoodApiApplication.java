package com.guialvesdev.springfoodapi;

import com.guialvesdev.springfoodapi.insfrastruture.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class SpringFoodApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringFoodApiApplication.class, args);
	}

}
