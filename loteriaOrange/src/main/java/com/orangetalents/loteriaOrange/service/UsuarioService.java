package com.orangetalents.loteriaOrange.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orangetalents.loteriaOrange.model.Jogo;
import com.orangetalents.loteriaOrange.model.Usuario;
import com.orangetalents.loteriaOrange.repository.JogoRepository;
import com.orangetalents.loteriaOrange.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JogoRepository jogoRepository; 
	
	public ResponseEntity<List<Jogo>> pegarJogos(String email) {
		Optional<Usuario> usuario = usuarioRepository.findAllByEmail(email);
		
		if (usuario.isPresent())
			return ResponseEntity.ok(usuario.get().getJogos());
		else
			return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Jogo> gerarJogos(Usuario usuarioDados) {
		Usuario jogador;
		Optional<Usuario> usuario = usuarioRepository.findAllByEmail(usuarioDados.getEmail());
		
		if (emailCadastrado(usuarioDados.getEmail()))
			return ResponseEntity.notFound().build();
		
		if (!usuario.isPresent()) 
			
			jogador = usuarioRepository.save(usuarioDados);
		else
			jogador = usuario.get();
			
        String sorteados = "";
        
        do sorteados = sortearNumeros(); while (jaSorteado(sorteados, jogador.getJogos()));

        Jogo jogo = jogoRepository.save(new Jogo(sorteados, jogador));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(jogo);
	}
	    

	    public boolean emailCadastrado(String email) {
		    return usuarioRepository.findAllByEmail(email).isPresent();
	    }
	
	    public String sortearNumeros() {
	    	
        Random random = new Random();
        List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(
           1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
          11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
          21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
          31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
          41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
          51, 52, 53, 54, 55, 56, 57, 58, 59, 60));

        List<Integer> sorteados = new ArrayList<Integer>();
        String sorteadosString = "";
        int rodadas = 6;
      
        for (int i = 0, index = 0; i < rodadas; i++) {
            
            index = random.nextInt(numeros.size());
            sorteados.add(numeros.get(index));
            numeros.remove(index);
              
        }
        Collections.sort(sorteados);
        
        for (int i = 0; i < rodadas; i++) sorteadosString += sorteados.get(i).toString() + " ";
      
        return sorteadosString.trim();
	   
	}
	    public boolean jaSorteado(String sorteados, List<Jogo> jogos) {
	        
	        for (Jogo jogo : jogos) if (jogo.getNumeroDoJogo().equals(sorteados)) return true;
	        
	        return false;
	        
	    }
	
}
