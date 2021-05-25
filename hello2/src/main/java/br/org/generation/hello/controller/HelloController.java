package br.org.generation.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Annotation que indica que é uma classe controladora
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHelo(){

		return "Hello World!\n\n"
				+ "Meu objetivo de aprendizagem para essa semana é explorar algumas funcionalidades do Spring"
				+ " e me familiarizar com essa nova ferremanta, sendo persistente para superar os possíveis desafios que podem aparecer.";
	}
}
