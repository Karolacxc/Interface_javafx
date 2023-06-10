package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Cachorro implements Serializable {
    private String nome;
    private String cor;
    private String idade;
    private String raca;
    private String status;
    private ArrayList<Cachorro> caes;


    // Construtores
    public Cachorro(String nome, String cor, String idade2, String raca) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade2;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
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

    public StringProperty idadeProperty() {
        return new SimpleStringProperty(idade);
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

    public void cadastro(String nome, String cor, String idade, String raca) {
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