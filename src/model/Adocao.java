package model;

public class Adocao {
    public Cachorro dog;
    public Usuario user;

    //Construtores
    public Adocao (Cachorro dog, Usuario user){
        this.dog = dog;
        this.user = user;
    }

    //Métodos
    public Cachorro getCao(){
        return dog;
    }
    public Usuario getUsuario(){
        return user;
    }
}