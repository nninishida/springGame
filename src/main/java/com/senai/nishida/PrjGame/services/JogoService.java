package com.senai.nishida.PrjGame.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.senai.nishida.PrjGame.entities.Jogo;
import com.senai.nishida.PrjGame.repositories.JogoRepository;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;
	
	public JogoService (JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	//preparando buscas por id
	public Jogo getJogoById(Long Id) {
		return jogoRepository.findById(Id).orElse(null);
	}
	//preparando busca geral
	public List<Jogo> getAllJogo(){
		return jogoRepository.findAll();
	}
	//salvando o jogo
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	//apagando o jogo
	public void deleteJogo(Long Id) {
		jogoRepository.deleteById(Id);
	}

}
