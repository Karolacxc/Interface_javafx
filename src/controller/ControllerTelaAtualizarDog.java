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


public class ControllerTelaAtualizarDog extends Controller  {

    @FXML
    private TextField txtNomeA;
    @FXML
    private TextField txtCorA;
    @FXML
    private TextField txtIdadeA;
    @FXML
    private TextField txtRacaA;
    @FXML
    private Button btnAtuA;
    @FXML
    private Button btnCancelA;
    @FXML
    private Label labelStatusAtualizaDog;
    
    private Cachorro Cachorro;      ////
    private Stage dialogStage;      ///


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    public void setCachorro(Cachorro s){
        this.Cachorro=s;
        this.txtNomeA.setText(Cachorro.getNome());
        this.txtCorA.setText(Cachorro.getCor());
        this.txtIdadeA.setText(String.valueOf(Cachorro.getIdade()));
        this.txtRacaA.setText(Cachorro.getRaca());
    }
    public Cachorro getCachorro(){
        return Cachorro;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setResizable(false); // Impede o redimensionamento da tela

    }

    @FXML
    private void handleAtualizarCachorro(ActionEvent event) throws Exception {
        this.Cachorro.setNome(this.txtNomeA.getText().toUpperCase());
        this.Cachorro.setCor(this.txtCorA.getText().toUpperCase());
        this.Cachorro.setIdade(Integer.parseInt(this.txtIdadeA.getText()));
        this.Cachorro.setRaca(this.txtRacaA.getText().toUpperCase());

        dialogStage.close();
    }

    @FXML
    private void handleCancelarAtualizacao(ActionEvent event) {
        dialogStage.close();
    }
    
}

