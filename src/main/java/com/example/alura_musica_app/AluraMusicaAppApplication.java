package com.example.alura_musica_app;

import com.example.alura_musica_app.main.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicaAppApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(AluraMusicaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
