package controller;

import data.DataUsuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Usuario;
import login.Login;

public class ControllerTelaLogin extends Controller {

    @FXML
    private TextField caixaTexto01; // login
    @FXML
    private TextField caixaTexto02; // senha
    @FXML
    private Button btnAqui;
    @FXML
    private Button btnLogar;

    public void getLogin(Login s) {
        String status = "";
        this.senha = s.getSenha();
        this.email = s.getEmail();
        if (email.equals(caixaTexto01.getText()) && senha.equals(caixaTexto02.getText())) {
            status = "correto";
        }
        // Retornar status ou fazer algo com ele
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String status = ""; // Inicializar a variável status
        if (status.equals("correto")) {
            btnLogar.setOnMouseClicked(event -> {
                try {
                    mudarTela("telaTabAdocao.fxml", event);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }

        btnAqui.setOnMouseClicked(event -> {
            try {
                mudarTela("TelaCadastro.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}
