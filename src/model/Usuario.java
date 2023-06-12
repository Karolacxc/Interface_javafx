package model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private String nome;
    private String fone;
    private String email;
    private String senha;
    private String endereco;

    //construtores
    public Usuario(String nome, String fone, String email, String senha, String endereco) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    //metodos getter/setter
    public String getNome() {
        return nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //metodos utilizados.
    @Override
    public String toString() {
        return "Nome: " + this.nome +
                "\nTelefone: " + this.fone +
                "\nE-mail: " + this.email +
                "\nEndereço: " + this.endereco;
    }
}