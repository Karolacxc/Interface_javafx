package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog05 extends Controller {

  //////////// Tela Dog 05 //////////////

  @FXML
  private Button btnContinuar05;

  @FXML
  private Button btnVoltar05;


  @Override
  public void initialize(URL location, ResourceBundle resources) {

    //////////// Tela Dog 05 //////////////

    btnContinuar05.setOnAction(event -> {
      try{
        mudarTela("telaFormulario.fxml", event);
      }catch  (Exception e){
        e.printStackTrace();
      }  
    });
  
    btnVoltar05.setOnAction(event -> {
      try{
        mudarTela("telaEscolhaDoguinho.fxml", event);
      }catch  (Exception e){
        e.printStackTrace();
      }
    });
  }
}    