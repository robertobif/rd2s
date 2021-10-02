package com.rd2s.projeto.repository;

import com.rd2s.projeto.model.Posicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicoesRepository extends JpaRepository<Posicoes, Long> {
}
