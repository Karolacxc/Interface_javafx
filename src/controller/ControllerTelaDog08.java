package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerTelaDog08 extends Controller {


  //////////// Tela Dog 08 //////////////

  @FXML
  private Button btnContinuar08;

  @FXML
  private Button btnVoltar08;


  @Override
  public void initialize(URL location, ResourceBundle resources) {

     //////////// Tela Dog 08 //////////////

    btnContinuar08.setOnAction(event -> {
      try{
        mudarTela("telaFormulario.fxml", event);
      }catch  (Exception e){
        e.printStackTrace();
      }  
    });
  
    btnVoltar08.setOnAction(event -> {
    try{
      mudarTela("telaEscolhaDoguinho.fxml", event);
    }catch  (Exception e){
      e.printStackTrace();
    }
    }); 
      
  }
}