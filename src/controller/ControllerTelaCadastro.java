package controller;
import data.DataUsuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Usuario;
import javafx.stage.Stage;

public class ControllerTelaCadastro  extends Controller {

    @FXML
    private TextField textNome;
    @FXML
    private TextField textFone;
    @FXML
    private TextField textEnd;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textSenha;
    @FXML
    private Button btnCadastro;

    private Usuario Usuario;
    private Stage dialogStage;

    public Usuario getUsuario(){
       return usuario;
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


        btnCadastro.setOnAction(event -> {
            try {
                mudarTela("telaTabAdocao.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void cadastrarUsuario(ActionEvent event) throws Exception {
        //Testa se os campos não estão vazios
        if (!textNome.getText().isEmpty() && !textFone.getText().isEmpty() && !textEnd.getText().isEmpty()&& !textEmail.getText().isEmpty()&& !textSenha.getText().isEmpty()){
            String nome = textNome.getText().toUpperCase();
            String fone = textFone.getText().toUpperCase();
            String email = textEmail.getText().toUpperCase();
            String endereco = textEnd.getText().toUpperCase();
            String senha = textSenha.getText().toUpperCase();
            //this.usuario=new Usuario(nome, fone, email,senha, endereco); - falta adicionar no array se precisar 

            this.dialogStage.close();
        }
        else{
            textNome.requestFocus();
        }
    }
    private void limparCampos(){
        textNome.clear();
        textFone.clear();
        textEnd.clear();
        textEmail.setText("");
        textSenha.requestFocus();

     }
}