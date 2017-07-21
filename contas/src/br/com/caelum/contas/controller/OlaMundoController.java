package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	@RequestMapping("/olaMundoSpring")
	public String service(){
		System.out.println("Ola mundo!!");
		return "ola-mundo/ok";
	}

}
