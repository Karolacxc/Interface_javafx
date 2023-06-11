package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;


public class Cachorro implements Serializable {
    private String nome;
    private String cor;
    private int idade;
    private String raca;
    private String status;
    


    // Construtores
    public Cachorro(String nome, String cor, int idade2, String raca) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade2;                   
        this.raca = raca;
    }

    public Cachorro(){}

    // Métodos getters and setters
    public String getStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    // Métodos de propriedade
    public StringProperty nomeProperty() {
        return new SimpleStringProperty(nome);
    }

    public StringProperty corProperty() {
        return new SimpleStringProperty(cor);
    }

    public IntegerProperty idadeProperty() {
        return new SimpleIntegerProperty(idade);
    }

    public StringProperty racaProperty() {
        return new SimpleStringProperty(raca);
    }

    // Métodos diversos.

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCor: " + cor +
                "\nRaça: " + raca +
                "\nIdade: " + idade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cachorro other = (Cachorro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}