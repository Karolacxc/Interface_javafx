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
            try{
                mudarTela("telaFormulario.fxml", event);
            }catch  (Exception e){
                e.printStackTrace();
            }
        });

        btnVoltar06.setOnAction(event -> {
            try{
                mudarTela("telaEscolhaDoguinho.fxml", event);
            }catch  (Exception e){
                e.printStackTrace();
            }
        });

    }
}
