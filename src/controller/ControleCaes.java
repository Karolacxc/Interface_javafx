package controller;

import java.util.ArrayList;

import model.Cachorro;

public class ControleCaes {
    ArrayList <Cachorro> lista = new ArrayList<>();


    public void cadastro(String nome, String cor, int idade, String raca){
        Cachorro cadastroDogs = new Cachorro (nome, cor, idade, raca);
        lista.add(cadastroDogs);
      }
  
      public String listaDogs(){
          String listaNome = "";
          for (Cachorro c : lista){
              listaNome += c.toString() + "\n";
          }
          return listaNome;
      }

    //
}
