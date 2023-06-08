package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog03 extends Controller {

    //////////// Tela Dog 03 //////////////

    @FXML
    private Button btnContinuar03;

    @FXML
    private Button btnVoltar03;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Dog 03 //////////////

        btnContinuar03.setOnAction(event -> {
            mudarTela("telaFormulario.fxml", event);
        });

        btnVoltar03.setOnAction(event -> {
            mudarTela("telaEscolhaDoguinho.fxml", event);
        });

    }

}