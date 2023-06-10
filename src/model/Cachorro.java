package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cachorro implements Serializable{
    private String nome;
    private String cor;
    private int idade;
    private String raca;
    private String status;
    private ArrayList <Cachorro> caes;


    //Construtores
    public Cachorro (String nome, String cor, int idade2, String raca){
        this.nome = nome;
        this.cor = cor;
        this.idade = idade2;
        this.raca = raca;
    }
    
 //metodos getters and setters
   public String getStatus (){
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

    //metodos diversos.

    @Override
    public String toString(){
        return "nome: "+this.nome+
               "\nCor: "+this.cor+
               "\nRaca: "+this.raca+
               "\nIdade: "+this.idade;
    }

    public void cadastro(String nome, String cor, int idade, String raca){
        Cachorro cadastroDogs = new Cachorro (nome, cor, idade, raca);
        caes.add(cadastroDogs);
      }
  
      public String listaDogs(){
          String listaNome = "";
          for (Cachorro c : caes){
              listaNome += c.toString() + "\n";
          }
          return listaNome;
      }


public void RemoverCachorro (String nome){
    for (int i = 0; i < caes.size(); i++) {
        if (nome == caes.get(i).getNome()) {
            caes.remove(i);
        }
    }
}

public Object idadeProperty() {
    return null;
}
}