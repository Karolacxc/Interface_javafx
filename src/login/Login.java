package login;

import java.io.Serializable;
import data.DataUsuario;

public class Login implements Serializable {
    String email;
    String senha;

    public Login(String email, String senha) {
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

    public void cadastrarLogin(Login l) {
        DataUsuario log = new DataUsuario();
        log.cadastrarLogin(l);
    }
}
