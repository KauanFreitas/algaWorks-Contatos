package com.kauanFreitas;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

@GetMapping("/contatos")
	public ModelAndView listar() {
	ModelAndView mAD = new ModelAndView("listar");
	mAD.addObject("contatos", LISTA_CONTATOS);
	
	return mAD;
	}

@GetMapping ("/contatos/novo")
	public ModelAndView novo() {
	ModelAndView mAD = new ModelAndView("formulario");
	mAD.addObject("contato", new Contato());
	
	return mAD;
	}

@PostMapping("/contatos")
	public String cadastrar(Contato contato) {
	String id = UUID.randomUUID().toString() ; 
	
	contato.setId(id);
	
	LISTA_CONTATOS.add(contato);
	return "redirect:/contatos";
}

@GetMapping ("/contatos/{id}/editar")
	public ModelAndView editar(@PathVariable String id) {
		
		ModelAndView modelAndView = new ModelAndView("formulario");
		Contato ctt = procurarContato(id);		
		modelAndView.addObject("contato", ctt);
		
		return modelAndView;
	}

	public Contato procurarContato(String id) {
		for (int i = 0; i < LISTA_CONTATOS.size(); i++) {
			Contato contato = LISTA_CONTATOS.get(i);
			
			if(contato.getId().equals(id)) {
				return contato;
			}
		}
		return null;
	}



}