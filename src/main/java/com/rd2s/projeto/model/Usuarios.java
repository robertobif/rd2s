package com.rd2s.projeto.model;


import java.util.Set;

import com.rd2s.projeto.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "USUARIOS")
public class Usuarios extends AbstractEntity {

    @Column(name = "NOME")
    @NotNull
    @Size (max=100, message = "Nome não pode ter mais que 50 caracteres.")
    private String Nome;

    @Column(name = "LOGIN")
    @NotNull
    @Size (max=100, message = "Nome não pode ter mais que 50 caracteres.")
    private String Login;

    @Column(name = "SENHA")
    @NotNull
    @Size (min= 8 , max= 16, message = "Senha não pode ter no mínimo 8 e no máximo 16 caracteres.")
    private String Senha;

    @Column(name = "EMAIL_RECUPERACAO")
    @NotNull
    @Size (max=100, message = "E-mail de recuperação não pode ter mais que 50 caracteres.")
    private String emailRecuperacao;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmailRecuperacao() {
        return emailRecuperacao;
    }

    public void setEmailRecuperacao(String emailRecuperacao) {
        this.emailRecuperacao = emailRecuperacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + Login +
                '}';
    }
}
