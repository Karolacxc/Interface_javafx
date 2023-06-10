package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaFormulario extends Controller {

    //////////// Tela Formulario //////////////

    @FXML
    private Button btnContiForm;

    @FXML
    private Button btnCancelForm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        btnContiForm.setOnAction(event -> {
            try {
                mudarTela("../tela/TelaAdocConcluida.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        btnCancelForm.setOnAction(event -> {
            
                try {
                    mudarTela("../tela/TelaTabAdocao.fxml", event);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
        });

    }
}