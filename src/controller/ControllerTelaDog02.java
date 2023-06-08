package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog02 extends Controller {

    //////////// Tela Dog 02 //////////////

    @FXML
    private Button btnContinuar02;

    @FXML
    private Button btnVoltar02;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Dog 02 //////////////

        btnContinuar02.setOnAction(event -> {
            mudarTela("telaFormulario.fxml", event);
        });

        btnVoltar02.setOnAction(event -> {
            mudarTela("telaEscolhaDoguinho.fxml", event);
        });

    }

}

/////