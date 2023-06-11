package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Cachorro implements Serializable {
    private String nome;
    private String cor;
    private int idade;
    private String raca;
    private String status;                               
    private ArrayList<Cachorro> caes;


    // Construtores
    public Cachorro(String nome, String cor, int idade2, String raca) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade2;                    ////  this.idade = idade2;    2??
        this.raca = raca;
    }

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

    public void cadastro(String nome, String cor, int idade, String raca) {
        Cachorro cadastroDogs = new Cachorro(nome, cor, idade, raca);
        caes.add(cadastroDogs);
    }

    public String listaDogs() {
        String listaNome = "";
        for (Cachorro c : caes) {
            listaNome += c.toString() + "\n";
        }
        return listaNome;
    }


    public void removerCachorro(String nome) {
        for (int i = 0; i < caes.size(); i++) {
            if (nome.equals(caes.get(i).getNome())) {
                caes.remove(i);
                break;
            }
        }
    }
}