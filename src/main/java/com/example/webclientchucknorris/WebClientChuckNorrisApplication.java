package com.example.webclientchucknorris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebClientChuckNorrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientChuckNorrisApplication.class, args);
	}

}


// *** Damit wir in unserem Back-End die API ansprechen können, nutzen wir die > WebClient