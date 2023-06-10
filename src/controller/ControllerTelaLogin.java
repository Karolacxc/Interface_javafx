package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ControllerTelaLogin extends Controller {

    @FXML
    private TextField caixaTexto01; // login
    @FXML
    private TextField caixaTexto02; // senha
    @FXML
    private Button btnCadastro;
    @FXML
    private Button btnLogar;

    private ControleUsuario controleUsuario;

@Override
    public void initialize(URL location, ResourceBundle resources) {
        String status = ""; // Inicializar a variável status
        if (status.equals("correto")) {
            btnLogar.setOnMouseClicked(event -> {
                try {
                    mudarTela("/telaTabAdocao.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        btnCadastro.setOnMouseClicked(event -> {
            try {
                mudarTela("/TelaCadastro.fxml", event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setControleUsuario(ControleUsuario controleUsuario) {
        this.controleUsuario = controleUsuario;
    }

    public void getLogin(ControleUsuario s) throws FileNotFoundException, ClassNotFoundException, IOException {
        String status = "";
        if (s.loginUsuario(caixaTexto01.getText(), caixaTexto02.getText())) {
            status = "correto";
        }
        // Retornar status ou fazer algo com ele
    }
}

    