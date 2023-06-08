package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaLogin extends Controller {

    //////////// Tela Formulario //////////////

    @FXML
    private Button btnContinForm;

    @FXML
    private Button btnCancelForm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Formulario //////////////

        btnContinForm.setOnAction(event -> {
            mudarTela("telaAdocConcluida.fxml", event);
        });

        btnCancelForm.setOnAction(event -> {
            mudarTela("telaEscolhaDoguinho.fxml", event);
        });

    }
}
