package com.rd2s.projeto.repository;

import com.rd2s.projeto.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}