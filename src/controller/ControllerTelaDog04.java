package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog04 extends Controller {

  //////////// Tela Dog 04 //////////////

  @FXML
  private Button btnContinuar04;

  @FXML
  private Button btnVoltar04;

  
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    //////////// Tela Dog 04 //////////////

    btnContinuar04.setOnAction(event -> {
      try{
        mudarTela("telaFormulario.fxml", event);
      }catch  (Exception e){
        e.printStackTrace();
      }
    });
  
    btnVoltar04.setOnAction(event -> {
      try{
        mudarTela("telaEscolhaDoguinho.fxml", event);
      }catch  (Exception e){
        e.printStackTrace();
      }
    });
    
}
}    