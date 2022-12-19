package cujae.edu.cu.bibcujae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BibcujaeApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibcujaeApplication.class, args);
	}
}
