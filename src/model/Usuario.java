package model;

import java.io.Serializable;
import data.DataUsuario;

public class Usuario implements Serializable {
    String nome;
    String email;
    String senha;

    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
