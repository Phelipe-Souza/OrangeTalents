package com.orangetalents.loteriaOrange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.loteriaOrange.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
