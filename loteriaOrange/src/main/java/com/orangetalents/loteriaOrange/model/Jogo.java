package com.orangetalents.loteriaOrange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_jogos")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String numeroDoJogo;
	
	@ManyToOne
	@JsonIgnoreProperties("jogos")
	private Usuario usuario;

	
	
	
    public Jogo() {}
	
	public Jogo(String jogo, Usuario usuario) {
		this.numeroDoJogo = jogo;
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroDoJogo() {
		return numeroDoJogo;
	}

	public void setNumeroDoJogo(String numeroDoJogo) {
		this.numeroDoJogo = numeroDoJogo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
