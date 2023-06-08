package controller;
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
            try{
                mudarTela("telaAdocConcluida.fxml", event);
            }catch  (Exception e){
                e.printStackTrace();
            }
        });

        btnCancelForm.setOnAction(event -> {
            try{
                mudarTela("telaEscolhaDoguinho.fxml", event);
            }catch  (Exception e){
                e.printStackTrace();
            }
        });

    }
}
