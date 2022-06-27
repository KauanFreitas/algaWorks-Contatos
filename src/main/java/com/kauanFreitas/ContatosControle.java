package com.kauanFreitas;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatosControle {
	
	private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
		
	static {
		LISTA_CONTATOS.add(new Contato("1", "Maria", "+55 11 999999999"));
		LISTA_CONTATOS.add(new Contato("2", "João", "+55 11 988888888"));
		LISTA_CONTATOS.add(new Contato("3", "Fernando", "+55 11 977777777"));
		LISTA_CONTATOS.add(new Contato("4", "Kelly", "+55 11 966666666"));
		LISTA_CONTATOS.add(new Contato("5", "Alexandre", "+55 11 955555555"));
	}
	
	
	
	@GetMapping("/")
	public String paginaInicial() {
		return "index";
	}
}
