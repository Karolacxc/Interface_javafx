package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaFormulario extends Controller {

    //////////// Tela Formulario //////////////

    @FXML
    private Button btnContinForm;

    @FXML
    private Button btnCancelForm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Formulario //////////////

        btnContinForm.setOnAction(event -> {
            try {
                mudarTela("telaAdocConcluida.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        btnCancelForm.setOnAction(event -> {
            
                try {
                    mudarTela("telaTabAdocao.fxml", event);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
        });

    }
}