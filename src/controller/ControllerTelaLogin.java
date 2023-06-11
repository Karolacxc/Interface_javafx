package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import data.DataUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Usuario;

import javafx.event.ActionEvent;


public class ControllerTelaLogin extends Controller {

    @FXML
    private TextField caixaTexto01; // login
    @FXML
    private TextField caixaTexto02; // senha
    @FXML
    private Button btnCadastro;
    @FXML
    private Button btnLogarAdm;
    @FXML
    private Button btnLogar;

    private ControleUsuario controleUsuario;

@Override
public void initialize(URL location, ResourceBundle resources) {
    btnLogar.setOnAction( event -> {
        String nome = caixaTexto01.getText();
        String senha = caixaTexto02.getText();
        
        boolean entrou = false;
        DataUsuario dataUsuario = new DataUsuario();
        Usuario usuario;
        try {
            usuario = dataUsuario.readUsuario(nome);
            
            if (usuario != null && usuario.getSenha().equals(senha)) {
                mudarTela("../tela/TelaTabAdocao.fxml", event);
                entrou = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (!entrou) {
            // Caso o login não seja encontrado, exiba uma mensagem de erro ou tome a ação apropriada.
        }
    });
    
    btnLogarAdm.setOnMouseClicked(event -> {
        try {
            mudarTela("../tela/telaAdm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
     btnCadastro.setOnMouseClicked(event -> {
        try {
            mudarTela("../tela/telaCadastro.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
}

public void setControleUsuario(ControleUsuario controleUsuario) {
    this.controleUsuario = controleUsuario;
}

public void getLogin(ControleUsuario s) { 
    String status = "";
    try {
        if (s.loginUsuario(caixaTexto01.getText(), caixaTexto02.getText())) {
           
            status = "correto";
        } else {
            status = "incorreto";
        }
        // Faça algo com o status, como exibir uma mensagem ou tomar ação apropriada
    } catch (FileNotFoundException | ClassNotFoundException e) {
        e.printStackTrace();
        // Lidar com a exceção de arquivo não encontrado ou classe não encontrada
    } catch (IOException e) {
        e.printStackTrace();
        // Lidar com a exceção de I/O
    }
}
}

