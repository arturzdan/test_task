package com.game.tic_tac_toe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
