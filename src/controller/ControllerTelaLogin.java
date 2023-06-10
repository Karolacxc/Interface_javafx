package controller;
import data.DataUsuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Usuario;
import login.Login;

public class ControllerTelaLogin  extends Controller {

    @FXML
    private TextField caixaTexto01;//login
    @FXML
    private TextField caixaTexto02;//senha
    @FXML
    private Button btnAqui;
    @FXML
    private Button btnLogar;

    
    @FXML
    public void getLogin(Login s){
       String status = null;
    this.senha = s.getSenha();
       this.email = s.getEmail();
       if(email == this.textFieldcaixaTexto01.setText(Usuario.getEmail())){
        if (senha == this.textFieldcaixaTexto02.setText(Usuario.getSenha())){
            status = correto;
        }
       }
       return status;
    }

    



    @Override
    public void initialize(URL location, ResourceBundle resources) {
      if(status == correto){ 
        btnLogar.setOnMouseClicked(event -> {
         mudarTela("telaTabAdocao.fxml", event);
        }) ;
        }



        btnAqui.setOnMouseClicked(event -> {
        mudarTela("TelaCadastro.fxml", event);
      });


    }

}