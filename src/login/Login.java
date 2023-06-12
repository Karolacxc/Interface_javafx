package login;

import java.io.Serializable;
import data.DataUsuario;

public class Login implements Serializable {
    String nome;
    String email;
    String senha;

    public Login(String nome, String senha, String email) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
