package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ControllerTelaAdm extends Controller {

    @FXML
    private TextField loginAdm; // login
    @FXML
    private TextField senhaAdm; // senha
    @FXML
    private Button btnLogar02;
@FXML
    private Button atualizarDog;
    

@Override
    public void initialize(URL location, ResourceBundle resources) { // Inicializar a variável status
        if ("Administrador".equals(loginAdm.getText())) {
            if("12345".equals(senhaAdm.getText())){
            btnLogar02.setOnMouseClicked(event -> {
                try {
                    mudarTela("../tela/TelaCadastrarDog.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            atualizarDog.setOnMouseClicked(event -> {
                try {
                    mudarTela("../tela/TelaAtualizarDog.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    }
}

    