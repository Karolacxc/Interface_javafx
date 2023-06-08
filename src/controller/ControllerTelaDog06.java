package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog06 extends Controller {

    //////////// Tela Dog 06 //////////////

    @FXML
    private Button btnContinuar06;

    @FXML
    private Button btnVoltar06;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Dog 06 //////////////

        btnContinuar06.setOnAction(event -> {
            mudarTela("telaFormulario.fxml", event);
        });

        btnVoltar06.setOnAction(event -> {
            mudarTela("telaEscolhaDoguinho.fxml", event);
        });

    }
}
