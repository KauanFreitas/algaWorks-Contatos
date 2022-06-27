package com.kauanFreitas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatosControle {

	@GetMapping("/")
	public String paginaInicial() {
		return "index";
	}
}
