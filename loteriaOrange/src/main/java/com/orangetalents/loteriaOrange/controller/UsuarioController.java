package com.orangetalents.loteriaOrange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.loteriaOrange.model.Jogo;
import com.orangetalents.loteriaOrange.model.Usuario;
import com.orangetalents.loteriaOrange.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	

	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{email}")
	public ResponseEntity<List<Jogo>> buscarJogos(@PathVariable String email) {
		return service.pegarJogos(email);
	}
	
	
	@PostMapping("/jogar")
	public ResponseEntity<Jogo> jogar(@RequestBody Usuario usuario){
		return service.gerarJogos(usuario);
	}
	

}
