package controller;

import data.DataCachorro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cachorro;


public class ControllerTelaCadastrarDog extends Controller  {

    @FXML
    private TextField txtNomeC;
    @FXML
    private TextField txtCorC;
    @FXML
    private TextField txtIdadeC;
    @FXML
    private TextField txtRacaC;
    @FXML
    private Label labelStatusCadastroDog;
    @FXML
    private Button btnAtuC;
    @FXML
    private Button btnCancelC;
    
    private Cachorro Cachorro;      ////

    private Stage dialogStage;     //// 
    
    public Cachorro getCachorro(){
        return Cachorro;
    }
     public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
    }    

    @FXML
    private void cadastrarCachorro(ActionEvent event) throws Exception {
        //Testa se os campos não estão vazios
        if (!txtNomeC.getText().isEmpty() && !txtCorC.getText().isEmpty() && !txtIdadeC.getText().isEmpty() && !txtRacaC.getText().isEmpty()){
            String nome = txtNomeC.getText().toUpperCase();
            String cor = txtCorC.getText().toUpperCase();
            int idade = Integer.parseInt(txtIdadeC.getText());
            String raca = txtRacaC.getText().toUpperCase();

            this.Cachorro=new Cachorro(nome,  cor,  idade, raca);
           
            this.dialogStage.close();
        }
        else{
            labelStatusCadastroDog.setText ("Dados Inválidos");
            txtNomeC.requestFocus();
        }
    }
    
        private void limparCampos(){     
            txtNomeC.clear();
            txtCorC.clear();
            txtIdadeC.requestFocus();
            txtRacaC.clear();
        }

    @FXML
    private void handleCancelarCadastro(ActionEvent event) {
        this.dialogStage.close();
    }

}
