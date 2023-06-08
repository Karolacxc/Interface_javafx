package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog01 extends Controller {

    //////////// Tela Dog 01 //////////////

    @FXML
    private Button btnContinuar01;

    @FXML
    private Button btnVoltar01;

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //////////// Tela Dog 01 //////////////

        btnContinuar01.setOnAction(event -> {
            try{
                mudarTela("telaFormulario.fxml", event);
            }catch  (Exception e){
                e.printStackTrace();
            }
        });

        btnVoltar01.setOnAction(event -> {
             try{
                mudarTela("telaEscolhaDoguinho.fxml", event);
            }catch  (Exception e){
                e.printStackTrace();
            }
        });

    }
}