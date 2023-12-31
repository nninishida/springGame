package com.senai.nishida.PrjGame.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.nishida.PrjGame.entities.Jogo;
import com.senai.nishida.PrjGame.services.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; //html sem extenção
	}
	private final JogoService jogoService;

	@Autowired
	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo (@PathVariable Long Id) {
		Jogo jogo = jogoService.getJogoById(Id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Jogo createJogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping
	public List<Jogo> getAllJogo() {
		return jogoService.getAllJogo();
	}

	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long Id) {
		jogoService.deleteJogo(Id);
	}

}
