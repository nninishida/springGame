package com.senai.nishida.PrjGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.senai.nishida.PrjGame.entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
