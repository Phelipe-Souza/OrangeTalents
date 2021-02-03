package com.orangetalents.loteriaOrange.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jogos")
public class Jogo {
	
	private long id;
	
	private String numeroDoJogo;
	
	private Usuario usuario;

}
