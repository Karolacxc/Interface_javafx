package model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String fone;
    private String email;
    private String senha;
    private String endereco;
    private int codigo;
    private static int cont;

    //construtores
    public Usuario (String nome, String fone, String email, String senha, String endereco, int codigo, int cont) {
        cont++;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.codigo = cont;
    }

    public Usuario(){}

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

    public int getCodigo(){
        return codigo;
    }

    //metodos utilizados.
    @Override
    public String toString(){
        return "nome: "+this.nome+
               "\nTelefone: "+this.fone+
               "\nE-mail: "+this.email+
               "\nEndereço: "+this.endereco;
    }
    

}