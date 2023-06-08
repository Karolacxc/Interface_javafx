package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog07 extends Controller {

    //////////// Tela Dog 07 //////////////

    @FXML
    private Button btnContinuar07;

    @FXML
    private Button btnVoltar07;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Dog 07 //////////////

        btnContinuar07.setOnAction(event -> {
            mudarTela("telaFormulario.fxml", event);
        });

        btnVoltar07.setOnAction(event -> {
            mudarTela("telaEscolhaDoguinho.fxml", event);
        });

    }
}
