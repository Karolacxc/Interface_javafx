package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControllerGeral implements Initializable{
    
        @FXML
        private Button btnContinuar;
    
        @FXML
        private Button btnVoltar;
      
        @Override
        public void initialize(URL location, ResourceBundle resources) {
    
            btnContinuar.setOnAction(event -> {
                mudarTela("telaFormulario.fxml", event);
            });
    
            btnVoltar.setOnAction(event -> {
                mudarTela("telaEscolhaDoguinho.fxml", event);
            });
    
        }
    }
////////



}
