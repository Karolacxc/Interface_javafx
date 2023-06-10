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


public class ControllerTelaCadastrarDog implements Initializable {

    @FXML
    private TextField textFieldCadastroCachorroId;
    @FXML
    private TextField textFieldCadastroCachorroDescricao;
    @FXML
    private TextField textFieldCadastroCachorroPreco;
    @FXML
    private TextField textFieldCadastroCachorroEstoque;
    @FXML
    private Label labelStatusCadastroCachorro;
    @FXML
    private Button buttonCadastrarCachorro;
    @FXML
    private Button buttonCancelarCadastroCachorro;
    
    private Cachorro Cachorro;
    private Stage dialogStage;
    
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
        if (!textFieldCadastroCachorroDescricao.getText().isEmpty() && !textFieldCadastroCachorroPreco.getText().isEmpty() && !textFieldCadastroCachorroEstoque.getText().isEmpty()){
            String descricao = textFieldCadastroCachorroDescricao.getText().toUpperCase();
            double preco = Double.parseDouble(textFieldCadastroCachorroPreco.getText());
            int estoque = Integer.parseInt(textFieldCadastroCachorroEstoque.getText());
            this.Cachorro=new Cachorro(descricao,  preco,  estoque);
           
            this.dialogStage.close();
        }
        else{
            labelStatusCadastroCachorro.setText ("Dados Inválidos");
            textFieldCadastroCachorroDescricao.requestFocus();
        }
    }
    
    private void limparCampos(){     
       textFieldCadastroCachorroId.clear();
        textFieldCadastroCachorroDescricao.clear();
        textFieldCadastroCachorroPreco.clear();
        textFieldCadastroCachorroEstoque.setText("");
        textFieldCadastroCachorroDescricao.requestFocus();
        
    }

    @FXML
    private void handleCancelarCadastro(ActionEvent event) {
        this.dialogStage.close();
    }

}
