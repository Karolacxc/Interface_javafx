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


public class ControllerTelaAtualizarDog implements Initializable {

    @FXML
    private TextField textFieldAtualizarCachorroId;
    @FXML
    private TextField textFieldAtualizarCachorroDescricao;
    @FXML
    private TextField textFieldAtualizarCachorroPreco;
    @FXML
    private TextField textFieldAtualizarCachorroEstoque;
    @FXML
    private Button buttonAtualizarCachorro;
    @FXML
    private Button buttonCancelarAtualizarCachorro;
    @FXML
    private Label labelStatusCadastroCachorro;
    
    private Cachorro Cachorro;
    private Stage dialogStage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    public void setCachorro(Cachorro s){
        this.Cachorro=s;
        this.textFieldAtualizarCachorroId.setText(String.valueOf(Cachorro.getId()));
        this.textFieldAtualizarCachorroDescricao.setText(Cachorro.getDescricao());
        this.textFieldAtualizarCachorroPreco.setText(String.valueOf(Cachorro.getPreco()));
        this.textFieldAtualizarCachorroEstoque.setText(String.valueOf(Cachorro.getEstoque()));
    }
    public Cachorro getCachorro(){
        return Cachorro;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleAtualizarCachorro(ActionEvent event) throws Exception {
        this.Cachorro.setDescricao(this.textFieldAtualizarCachorroDescricao.getText().toUpperCase());
        this.Cachorro.setPreco(Double.parseDouble(this.textFieldAtualizarCachorroPreco.getText()));
        this.Cachorro.setEstoque(Integer.parseInt(this.textFieldAtualizarCachorroEstoque.getText()));
        dialogStage.close();
    }

    @FXML
    private void handleCancelarAtualizacao(ActionEvent event) {
        dialogStage.close();
    }
    
}
