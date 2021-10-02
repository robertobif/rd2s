package com.rd2s.projeto.resource;

import com.rd2s.projeto.model.Cidade;
import com.rd2s.projeto.model.Usuarios;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuariosDTO {

    private String Login;
    private String Senha;
    private String emailRecuperacao;

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

    public static UsuariosDTO toDTO(Usuarios usuarios) {
        UsuariosDTO dto = new UsuariosDTO();
        dto.setLogin(usuarios.getLogin());
        dto.setSenha(usuarios.getSenha());
        dto.setEmailRecuperacao(usuarios.getEmailRecuperacao());
        return dto;
    }

    public static Usuarios fromDTO(UsuariosDTO usuariosDto) {
        Usuarios entity = new Usuarios();
        entity.setLogin(usuariosDto.getLogin());
        entity.setSenha(usuariosDto.getSenha());
        entity.setEmailRecuperacao(usuariosDto.getEmailRecuperacao());
        return entity;
    }

}
