package com.uca.capas.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	//Ejemplo 1 ResponseBody
	@GetMapping(path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE) //devuelve texto plano en lugar de texto http
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos\n" + "Programación N-Capas";
	}

}
